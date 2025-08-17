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


package api.justlime.redeemcodex.models

import org.bukkit.Sound
import org.bukkit.entity.Player
import java.io.Serializable

/**
 * A data class to hold the state of a sound to be played.
 *
 * @param sound The name of the Bukkit Sound enum.
 * @param volume The volume of the sound, from 0.0 to 1.0.
 * @param pitch The pitch of the sound, from 0.5 to 2.0.
 */
data class SoundState(
    var sound: String? = null,
    var volume: Float = 1f,
    var pitch: Float = 1f
) : Serializable {

    companion object {
        // Cache all Bukkit sounds in a map for high-performance lookups.
        private val SOUND_MAP: Map<String, Sound> by lazy {
            enumValues<Sound>().associateBy { it.name.uppercase() }
        }
    }

    /**
     * Plays the sound for a specific player at their location.
     *
     * @param player The player who will hear the sound.
     */
    fun playSound(player: Player) {
        if (sound.isNullOrBlank()) return
        val resolvedSound = SOUND_MAP[sound!!.uppercase()] ?: return
        player.playSound(player.location, resolvedSound, volume, pitch)
    }
}