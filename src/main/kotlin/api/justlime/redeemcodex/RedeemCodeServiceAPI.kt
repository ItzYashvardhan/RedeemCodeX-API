/*
 * RedeemCodeX - Plugin License Agreement
 * Copyright © 2024 Yashvardhan
 *
 * This software is a paid plugin developed by Yashvardhan ("Author") and is provided to you ("User") under the following terms:
 *
 * 1. Usage Rights:
 *    - This plugin is licensed, not sold.
 *    - One license grants usage on **one server network only**, unless explicitly agreed otherwise.
 *    - You may not sublicense, share, leak, or resell the plugin or any part of it.
 *
 * 2. Restrictions:
 *    - You may not decompile, reverse engineer, or modify the plugin.
 *    - You may not redistribute the plugin in any form.
 *    - You may not upload this plugin to any public or private repository or distribution platform.
 *
 * 3. Support & Updates:
 *    - Support is provided to verified buyers only.
 *    - Updates are available as long as development continues or within the support duration stated at purchase.
 *
 * 4. Termination:
 *    - Any violation of this agreement terminates your rights to use this plugin immediately, without refund.
 *
 * 5. No Warranty:
 *    - The plugin is provided "as is", without warranty of any kind. Use at your own risk.
 *    - The Author is not responsible for any damages, data loss, or server issues resulting from usage.
 *
 * For inquiries,
 * Email: itsyashvardhan76@gmail.com
 * Discord: https://discord.gg/rVsUJ4keZN
 *
 *
 */


package api.justlime.redeemcodex

import api.justlime.redeemcodex.models.RCXPlaceHolder
import api.justlime.redeemcodex.models.RedeemCode
import api.justlime.redeemcodex.models.RedeemTemplate

/**
 * RedeemCodeServiceAPI defines the core contract for managing redeemable codes.
 * It includes functionalities for code generation, retrieval, deletion, and insertion.
 */
interface RedeemCodeServiceAPI {

    /**
     * Retrieves a [RedeemCode] by its string representation.
     *
     * @param code The string key of the redeem code.
     * @return The [RedeemCode] object if found, or null if it does not exist.
     */
    fun getCode(code: String): RedeemCode?

    /**
     * Returns all redeem code keys stored in the system.
     *
     * @return A mutable set of redeem code strings.
     */
    fun getCodes(): MutableSet<String>

    /**
     * Generates a single redeem code associated with a unique name and template.
     *
     * @param uniqueName A unique identifier for the code.
     * @param template The template used for code generation. Defaults to "DEFAULT".
     * @return The newly generated [RedeemCode].
     */
    fun generateCode(uniqueName: String, template: String = "DEFAULT"): RedeemCode

    /**
     * Generates a single redeem code with a specified digit length and template.
     *
     * @param digit The length of the redeem code.
     * @param template The template used for code generation. Defaults to "DEFAULT".
     * @return The newly generated [RedeemCode].
     */
    fun generateCode(digit: Int, template: String = "DEFAULT"): RedeemCode

    /**
     * Generates multiple redeem codes with a specified digit length and amount.
     *
     * @param digit The length of the redeem code.
     * @param template The template used for code generation. Defaults to "DEFAULT".
     * @param amount The number of codes to generate.
     * @return A set of newly generated [RedeemCode]s.
     */
    fun generateCode(digit: Int, template: String = "DEFAULT", amount: Int): Set<RedeemCode>

    /**
     * Generates a list of redeem codes with specified digit length and quantity.
     *
     * @param digit The length of each redeem code.
     * @param amount The number of codes to generate. Defaults to 1.
     * @return A list of generated [RedeemCode]s.
     */
    fun generateCode(digit: Int, amount: Int = 1): List<RedeemCode>

    /**
     * Deletes a redeem code by its key.
     *
     * @param code The redeem code string to delete.
     * @return True if deletion was successful, false otherwise.
     */
    fun deleteCode(code: String): Boolean

    /**
     * Deletes multiple redeem codes in a single operation.
     *
     * @param codes A list of redeem code strings to delete.
     * @return True if all codes were successfully deleted, false otherwise.
     */
    fun deleteCodes(codes: List<String>): Boolean

    /**
     * Deletes all redeem codes from the storage.
     *
     * @return True if all codes were deleted successfully.
     */
    fun deleteAllCode(): Boolean


    /**
     * Attempts to synchronize a single [RedeemCode] with its associated [RedeemTemplate], if applicable.
     *
     * This method re-evaluates the given code and updates its properties
     * based on the latest version of the template.
     *
     * Useful when a template has been updated and existing codes need to reflect the changes.
     *
     * @param redeemCode The [RedeemCode] to synchronize.
     * @return `true` if synchronization was successful (template found and applied), `false` otherwise.
     */
    fun syncCode(redeemCode: RedeemCode): Boolean


    /**
     * Inserts or updates a redeem code.
     *
     * **Important!!**
     * This method **must be called** after generating new code or modifying
     * to ensure that all changes are saved.
     *
     * @param code The redeem code to insert or update.
     */
    fun upsertCode(code: RedeemCode)

    /**
     * Inserts or updates multiple [RedeemCode] entries in the storage.
     *
     * **Important!!**
     * This method **must be called** after generating new codes or modifying
     * to ensure that all changes are saved.
     *
     * @param code A list of [RedeemCode] instances to be inserted or updated.
     */
    fun upsertCodes(code: List<RedeemCode>)

}
