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

import api.justlime.redeemcodex.models.RCXPlaceHolder
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import java.util.*

/**
 * Service responsible for managing player data retrieval, caching, and offline notifications.
 *
 * This service acts as a bridge between the plugin and the server's user cache, providing
 * optimized lookups for OfflinePlayers and handling deferred messages (notifications)
 * for players who are currently offline.
 */
interface PlayerService {

    // =========================================================================
    //  PLAYER RETRIEVAL & CACHING
    // =========================================================================

    /**
     * Retrieves an [OfflinePlayer] instance by their name.
     *
     * @param playerName The name of the player to look up.
     * @return The [OfflinePlayer] object, or `null` if not found in the cache/server.
     */
    fun getOfflinePlayer(playerName: String): OfflinePlayer?

    /**
     * Retrieves a list of all known offline players.
     *
     * **Note:** Depending on the server size, this list can be large.
     * @return A list of all [OfflinePlayer]s known to the server/plugin.
     */
    fun getOfflinePlayers(): List<OfflinePlayer>

    /**
     * Retrieves a list of all cached player names.
     *
     * This is optimized for Tab-Completion and command arguments.
     *
     * @return A list of player name strings.
     */
    fun getPlayersList(): List<String>

    /**
     * Retrieves a list of all cached player UUIDs.
     *
     * @return A list of [UUID]s.
     */
    fun getPlayersUUID(): List<UUID>

    /**
     * Resolves a player's name to their unique UUID.
     *
     * @param playerName The name of the player.
     * @return The [UUID] of the player, or `null` if the name is not found.
     */
    fun getPlayerUUID(playerName: String): UUID?

    /**
     * Retrieves the full internal map of cached players.
     *
     * @return A MutableMap where Keys are [UUID]s and Values are Player Names.
     */
    fun getPlayers(): MutableMap<UUID, String>

    // =========================================================================
    //  NOTIFICATION MANAGEMENT
    // =========================================================================

    /**
     * Queues a batch of notifications for multiple offline players.
     * These notifications are persisted and delivered when the player next joins.
     *
     * @param uuidMap A list of pairs, where each Pair contains a target [UUID] and the [RCXPlaceHolder] data.
     */
    fun addNotification(uuidMap: List<Pair<UUID, RCXPlaceHolder>>)

    /**
     * Queues a specific "Gift" type notification for a single player.
     *
     * @param uuid The UUID of the recipient.
     * @param placeholder The data associated with the gift.
     */
    fun addGiftNotification(uuid: UUID, placeholder: RCXPlaceHolder)

    /**
     * Revokes (deletes) any pending notifications associated with a specific code.
     * Useful if a code is deleted or disabled before the player logs in.
     *
     * @param code The code identifier to clear.
     * @return A list of [RCXPlaceHolder]s that were removed (useful for logging or debugging).
     */
    fun clearNotification(code: String): List<RCXPlaceHolder>

    /**
     * Revokes (deletes) any pending notifications associated with a list of codes.
     *
     * @param codes The list of code identifiers to clear.
     * @return A list of [RCXPlaceHolder]s that were removed.
     */
    fun clearNotification(codes: List<String>): List<RCXPlaceHolder>

    /**
     * Revokes (deletes) any pending notifications generated by a specific template.
     *
     * @param template The template name to filter by.
     * @return A list of [RCXPlaceHolder]s that were removed.
     */
    fun clearNotifications(template: String): List<RCXPlaceHolder>

    /**
     * Checks for and delivers any pending notifications to a player who has just logged in.
     *
     * This should be called during the [org.bukkit.event.player.PlayerJoinEvent].
     *
     * @param player The player who has logged in.
     */
    fun notifyPlayer(player: Player)

    // =========================================================================
    //  INTERNAL LIFECYCLE
    // =========================================================================

    /**
     * **Internal Use Only.**
     * Manually adds a player to the internal name/UUID cache.
     *
     * @param player The player object to cache.
     */
    fun addPlayerCache(player: OfflinePlayer)

    /**
     * Initializes the service.
     * Loads the player cache (if applicable) and pending notifications from storage.
     * This method should be called once during plugin enablement.
     */
    fun init()
}