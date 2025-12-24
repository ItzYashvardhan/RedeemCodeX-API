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
 */

package api.justlime.redeemcodex.dao

import api.justlime.redeemcodex.models.core.RedeemCode
import api.justlime.redeemcodex.models.core.RedeemLog
import java.util.*

/**
 * DAO interface for managing the `redeem_log` table.
 * All methods consistently use the UUID type for player identifiers.
 */
interface RedeemLogDao {

    /**
     * Records a new redemption event in the database.
     */
    fun addRedeemLog(playerUUID: UUID, code: RedeemCode): Boolean

    fun getRedeemLog(playerUUID: UUID,code: String): List<RedeemLog>

    /**
     * Retrieves all redemption logs for a specific player.
     */
    fun getRedeemLogs(playerUUID: UUID): List<RedeemLog>

    /**
     * Retrieves all redemption logs for a specific code.
     */
    fun getRedeemLogsByCode(code: String): List<RedeemLog>


    /**
     * NEW: Retrieves all redemption logs associated with a specific template.
     */
    fun getRedeemLogsByTemplate(template: String): List<RedeemLog>

    /**
     * Deletes a single redemption log by its unique ID.
     */
    fun deleteRedeemLog(id: Int): Boolean

    /**
     * Deletes all redemption logs for a specific player.
     * @return The number of logs that were deleted.
     */
    fun deleteRedeemLogs(playerUUID: UUID): Int

    /**
     * Deletes all redemption logs for a specific code.
     * @return The number of logs that were deleted.
     */
    fun deleteRedeemLogs(code: String): Int

    fun deleteRedeemLogs(playerUUID: UUID,code: String): Int
}