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

package api.justlime.redeemcodex.service

import api.justlime.redeemcodex.models.core.CouponNotifier
import org.bukkit.entity.Player

interface ICouponNotifier {

    /**
     * Retrieves and displays all pending coupon notifications for a specific player.
     *
     * This is typically called when a player **joins the server** to inform them
     * of any rewards or gifts they received while they were offline.
     *
     * @param player The online player to fetch and display notifications for.
     */
    fun notify(player: Player)

    /**
     * Dispatches a single notification to a target user.
     *
     * * **Online:** The player receives the notification message immediately.
     * * **Offline:** The notification is silently persisted to the database and will be
     * delivered automatically when the player next joins (via [notify]).
     *
     * @param notifier The notification data containing the UUID, code, and sender info.
     */
    fun notify(notifier: CouponNotifier)

    /**
     * Dispatches a batch of notifications efficiently.
     *
     * This is optimized for bulk operations (e.g., "Give to All" commands) to
     * reduce database overhead. Like the single variant, it handles both
     * online delivery and offline persistence automatically.
     *
     * @param notifiers The list of notifications to process.
     */
    fun notify(notifiers: List<CouponNotifier>)

}