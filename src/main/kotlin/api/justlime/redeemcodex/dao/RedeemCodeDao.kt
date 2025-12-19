package api.justlime.redeemcodex.dao

import api.justlime.redeemcodex.enums.SortDirection
import api.justlime.redeemcodex.enums.SortProperty
import api.justlime.redeemcodex.models.RedeemCode
import api.justlime.redeemcodex.models.RedeemTemplate

/**
 * DAO interface for managing `redeem_codes` in the database.
 *
 * This interface handles all CRUD operations for RedeemCodes, including specific queries
 * for filtering by template, sorting, and batch processing.
 */
interface RedeemCodeDao {
    /**
     * Synchronously retrieves a specific code from the database.
     *
     * **Warning:** This blocks the current thread. Do not use on the main thread
     * unless absolutely necessary (e.g., inside an async task or restricted context).
     *
     * @param code The unique code identifier.
     * @return The [RedeemCode] object if found, or `null` otherwise.
     */
    fun get(code: String): RedeemCode?

    /**
     * Asynchronously retrieves all codes from the database.
     *
     * @param callback Called with the full list of [RedeemCode] objects.
     */
    fun get(callback: (redeemCodes: List<RedeemCode>) -> Unit)

    /**
     * Asynchronously retrieves all codes, sorted by a specific property.
     *
     * @param sortedBy The property to sort by (e.g., CREATED, CODE).
     * @param direction The sort direction (ASCENDING or DESCENDING).
     * @param callback Called with the sorted list of [RedeemCode] objects.
     */
    fun get(sortedBy: SortProperty, direction: SortDirection, callback: (redeemCodes: List<RedeemCode>) -> Unit)

    /**
     * Asynchronously retrieves a specific code.
     *
     * @param code The unique code identifier.
     * @param callback Called with the [RedeemCode] object, or `null` if not found.
     */
    fun get(code: String, callback: (redeemCode: RedeemCode?) -> Unit)

    /**
     * Asynchronously retrieves multiple specific codes by their identifiers.
     *
     * @param codes A list of code strings to fetch.
     * @param callback Called with the list of found [RedeemCode] objects.
     */
    fun get(codes: List<String>, callback: (redeemCodes: List<RedeemCode>) -> Unit)

    /**
     * Asynchronously retrieves codes associated with a specific template.
     *
     * @param template The name of the template.
     * @param lockedStatus Filter by sync status: `true` for synced, `false` for unsynced, or `null` for all.
     * @param callback Called with the filtered list of [RedeemCode] objects.
     */
    fun get(template: String, lockedStatus: Boolean?, callback: (redeemCodes: List<RedeemCode>) -> Unit)

    /**
     * Asynchronously retrieves a list of all code identifiers (names only).
     * This is lighter than fetching full objects if only names are needed.
     *
     * @param callback Called with the list of code strings.
     */
    fun getCodes(callback: (codes: List<String>) -> Unit)

    /**
     * Asynchronously retrieves sorted code identifiers (names only).
     *
     * @param sortedBy The property to sort by.
     * @param direction The sort direction.
     * @param callback Called with the sorted list of code strings.
     */
    fun getCodes(sortedBy: SortProperty, direction: SortDirection, callback: (codes: List<String>) -> Unit)

    /**
     * Asynchronously retrieves code identifiers filtered by template.
     *
     * @param template The template name to filter by.
     * @param lockedStatus Sync status filter.
     * @param callback Called with the list of matching code strings.
     */
    fun getCodes(template: String, lockedStatus: Boolean?, callback: (redeemCodes: List<String>) -> Unit)

    /**
     * Asynchronously finds codes that have expired based on their validity settings.
     *
     * @param callback Called with a list of expired code identifiers.
     */
    fun getExpiredCodes(callback: (redeemCodes: List<String>) -> Unit)

    /**
     * Asynchronously checks if a specific code exists in the database.
     * This is optimized to check existence without loading the full object.
     *
     * @param code The code identifier.
     * @param callback Called with `true` if the code exists, `false` otherwise.
     */
    fun lookUpCode(code: String, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously checks which of the provided codes exist in the database.
     *
     * @param codes A list of code identifiers to check.
     * @param callback Called with a list containing only the codes that were found.
     */
    fun lookUpCodes(codes: List<String>, callback: (codes: List<String>) -> Unit)

    /**
     * Asynchronously inserts a new code into the database.
     * Fails if the code already exists.
     *
     * @param redeemCode The code object to add.
     * @param callback Called with `true` if successful, `false` if the code exists or an error occurred.
     */
    fun addCode(redeemCode: RedeemCode, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously inserts multiple new codes in a batch transaction.
     *
     * @param redeemCodes The list of code objects to add.
     * @param callback Called with `true` if the batch operation was successful.
     */
    fun addCodes(redeemCodes: List<RedeemCode>, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously updates an existing code in the database.
     *
     * @param redeemCode The code object with updated values.
     * @param callback Called with `true` if the update was successful.
     */
    fun updateCode(redeemCode: RedeemCode, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously updates multiple existing codes in a batch transaction.
     *
     * @param redeemCodes The list of code objects to update.
     * @param callback Called with `true` if the batch update was successful.
     */
    fun updateCodes(redeemCodes: List<RedeemCode>, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously removes a code from the database.
     *
     * @param code The identifier of the code to remove.
     * @param callback Called with `true` if the deletion was successful.
     */
    fun removeCode(code: String, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously removes multiple codes from the database in a batch.
     *
     * @param codes The list of identifiers to remove.
     * @param callback Called with `true` if the batch deletion was successful.
     */
    fun removeCodes(codes: List<String>, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously removes **ALL** codes from the database.
     *
     * @param callback Called with `true` if the operation was successful.
     */
    fun removeAllCodes(callback: (success: Boolean) -> Unit)

    // =========================================================================
    //  CACHE & LOGIC (Synchronous / In-Memory)
    // =========================================================================

    /**
     * Triggers an asynchronous refresh of the internal in-memory cache.
     * This pulls the latest data from the database to update fast-access maps.
     *
     * @param callback Optional callback to execute when the cache refresh is complete.
     */
    fun fetch(callback: ((Unit) -> Unit) = {})

    /**
     * Synchronizes a RedeemCode object with its Template settings.
     * This is a pure logic operation and does not touch the database directly.
     *
     * @param redeemCode The code object to modify.
     * @param template The template to apply settings from.
     * @return `true` if the code was modified, `false` otherwise.
     */
    fun templateToRedeemCode(redeemCode: RedeemCode, template: RedeemTemplate): Boolean

    /**
     * Retrieves a list of all code identifiers currently held in the local cache.
     *
     * @return A MutableList of code strings.
     */
    fun getCachedCodes(): MutableList<String>

    /**
     * Retrieves a map of cached codes that require a PIN.
     *
     * @return A MutableMap where Key = Code and Value = PIN.
     */
    fun getCachedCodesWithPin(): MutableMap<String, Int>

    /**
     * Retrieves the cached map of target players for codes.
     *
     * @return A MutableMap where Key = Code and Value = List of Player Names/UUIDs.
     */
    fun getCachedTargets(): MutableMap<String, MutableList<String>>
}