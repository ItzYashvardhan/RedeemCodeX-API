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

package api.justlime.redeemcodex.utilities

import org.bukkit.OfflinePlayer
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
     * Retrieves an [org.bukkit.OfflinePlayer] instance by their name.
     *
     * @param playerName The name of the player to look up.
     * @return The [org.bukkit.OfflinePlayer] object, or `null` if not found in the cache/server.
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
     * @return A list of [java.util.UUID]s.
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
     * Loads the player cache (if applicable).
     * This method should be called once during plugin enablement.
     */
    fun init()
}