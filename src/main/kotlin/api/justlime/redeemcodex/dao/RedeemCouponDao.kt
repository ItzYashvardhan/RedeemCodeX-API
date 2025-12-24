/*
 * RedeemCodeX - Plugin License Agreement
 * Copyright © 2024 Yashvardhan
 *
 * This software is a paid plugin developed by Yashvardhan ("Author") and is provided to you ("User") under the following terms:
 *
 * (Your license agreement here)
 *
 * For inquiries,
 * Email: itsyashvardhan76@gmail.com
 * Discord: https://discord.gg/rVsUJ4keZN
 */

package api.justlime.redeemcodex.dao

import api.justlime.redeemcodex.models.core.RedeemCoupon
import java.util.*

/**
 * DAO interface for managing the `redeem_coupons` table.
 *
 * This acts as a "Coupon Wallet," tracking which coupons have been gifted to specific players.
 * It handles the mapping between Player UUIDs and Redeem Codes.
 */
interface RedeemCouponDao {

    /**
     * Asynchronously gifts a new coupon to a player.
     *
     * @param coupon The coupon object to add. ID and giftedAt might be ignored depending on implementation.
     * @param callback Called with `true` if the coupon was successfully added, or `false` if it already exists or failed.
     */
    fun add(coupon: RedeemCoupon, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously gifts multiple coupons in a single, efficient batch transaction.
     *
     * @param coupons A list of coupon objects to add.
     * @param callback Called with `true` if the batch operation was successful.
     */
    fun addCoupons(coupons: List<RedeemCoupon>, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously retrieves a specific coupon owned by a player.
     *
     * @param playerUUID The UUID of the player.
     * @param code The specific code to look for.
     * @param callback Called with the [RedeemCoupon] object if found, or `null` if the player does not own this coupon.
     */
    fun get(playerUUID: UUID, code: String, callback: (redeemCoupon: RedeemCoupon?) -> Unit)

    /**
     * Synchronously retrieves all coupons owned by a specific player.
     *
     * **Warning:** This blocks the current thread. Do not use on the main thread.
     *
     * @param playerUUID The UUID of the player.
     * @return A list of [RedeemCoupon] objects owned by the player.
     */
    fun get(playerUUID: UUID): List<RedeemCoupon>

    /**
     * Asynchronously retrieves all coupons owned by a specific player.
     *
     * @param playerUUID The UUID of the player.
     * @param callback Called with a list of [RedeemCoupon] objects owned by the player.
     */
    fun getCoupons(playerUUID: UUID, callback: (redeemCoupons: List<RedeemCoupon>) -> Unit)

    /**
     * Asynchronously retrieves all gifted coupons from the database for all players.
     *
     * **Note:** This can be a memory-intensive operation on large servers/databases.
     *
     * @param callback Called with a Set of all existing coupons.
     */
    fun getCoupons(callback: (redeemCoupons: Set<RedeemCoupon>) -> Unit)

    /**
     * Asynchronously retrieves all coupons associated with a specific template.
     *
     * @param template The template name.
     * @param callback Called with a list of [RedeemCoupon] objects.
     */
    fun getCouponsByTemplate(template: String, callback: (redeemCoupons: List<RedeemCoupon>) -> Unit)

    /**
     * Asynchronously retrieves all coupons owned by a specific player that match a specific template.
     *
     * @param playerUUID The UUID of the player.
     * @param template The template name.
     * @param callback Called with a list of [RedeemCoupon] objects.
     */
    fun getCouponsByTemplate(playerUUID: UUID, template: String, callback: (redeemCoupons: List<RedeemCoupon>) -> Unit)

    /**
     * Asynchronously removes a specific coupon code from **all** players who possess it.
     *
     * @param code The code identifier to wipe from the database.
     * @param callback Called with `true` if the operation executed successfully.
     */
    fun remove(code: String, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously revokes a specific coupon from a specific player.
     *
     * @param playerUUID The UUID of the player.
     * @param code The code to remove.
     * @param callback Called with `true` if the coupon was found and removed, `false` otherwise.
     */
    fun remove(playerUUID: UUID, code: String, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously revokes **all** coupons from a specific player (wipes their wallet).
     *
     * @param playerUUID The UUID of the player to reset.
     * @param callback Called with `true` if the operation was successful.
     */
    fun removeCoupons(playerUUID: UUID, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously removes a list of coupon codes from **all** players who possess them.
     *
     * @param code A list of code strings to wipe from the database.
     * @param callback Called with `true` if the operation executed successfully.
     */
    fun removeCoupons(code: List<String>, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously revokes multiple specific coupons from a single player in a transaction.
     *
     * @param playerUUID The UUID of the player.
     * @param codes A list of codes to remove from this player's wallet.
     * @param callback Called with `true` if the operation was successful.
     */
    fun removeCoupons(playerUUID: UUID, codes: List<String>, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously revokes multiple specific coupons from a single player in a transaction.
     *
     * @param playerUUID The UUID of the player.
     * @param codes A list of codes to remove from this player's wallet.
     * @param callback Called with `true` if the operation was successful.
     */
    fun removeCoupons(playerUUIDs: List<UUID>, codes: String, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously removes all coupons associated with a specific template from **all** players.
     *
     * @param template The template name.
     * @param callback Called with `true` if the operation executed successfully.
     */
    fun removeAllCouponsByTemplate(template: String, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously removes all coupons associated with a specific template from a specific player.
     *
     * @param playerUUID The UUID of the player.
     * @param template The template name.
     * @param callback Called with `true` if the operation executed successfully.
     */
    fun removeAllCouponsByTemplate(playerUUID: UUID, template: String, callback: (success: Boolean) -> Unit)

    fun removeAllCoupons(callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously checks if a player has been gifted the given coupon.
     *
     * @param playerUUID The UUID of the player.
     * @param code The code to check.
     * @param callback Called with `true` if the coupon exists in the player's wallet, `false` otherwise.
     */
    fun couponExists(playerUUID: UUID, code: String, callback: (success: Boolean) -> Unit)

    /**
     * Asynchronously filters a list of players to find which ones already own a specific coupon.
     *
     * @param playerUuids A list of UUIDs to check against the database.
     * @param code The coupon code to check for.
     * @param callback Called with a Set containing only the UUIDs from the input list that already own the coupon.
     */
    fun findPlayersWhoOwnCoupon(playerUuids: List<UUID>, code: String, callback: (playerUuids: Set<UUID>) -> Unit)


}