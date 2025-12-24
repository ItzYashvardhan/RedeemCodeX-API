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

package api.justlime.redeemcodex.models.core

import api.justlime.redeemcodex.enums.RedeemCategory
import api.justlime.redeemcodex.models.component.JTitle
import api.justlime.redeemcodex.models.component.MessageState
import api.justlime.redeemcodex.models.component.SoundState
import org.bukkit.inventory.ItemStack
import java.sql.Timestamp
import java.time.Instant
import java.util.*

data class RedeemCode(
    override var category: RedeemCategory = RedeemCategory.RedeemCode,
    var code: String,
    override var enabledStatus: Boolean,

    override var template: String, //Blank for disabled
    override var sync: Boolean,

    override var duration: String, //0s for disabled
    override var cooldown: String, //0s for disabled

    override var permission: String, //Blank for disabled
    override var pin: Int, //0 for disabled

    override var redemption: Int, //0 for infinite Redemption limit
    override var playerLimit: Int, //0 for infinite player limit
    override var condition: String,

    var usedBy: MutableMap<UUID, Int>,
    var validFrom: Timestamp, var lastRedeemed: MutableMap<UUID, Timestamp>,

    var target: MutableList<UUID>, //Blank for disabled
    override var commands: MutableList<String>, //Empty list for disabled

    override var rewards: MutableList<ItemStack> = mutableListOf(),
    override var messages: MessageState,
    override var sound: SoundState,

    var ipLimit: MutableMap<UUID, String>,//Key - Ip, Value - Redemption Count
    var modified: Timestamp,
    var server: String,
) : RedeemType {
    object Create {
        /**
         * Generated a RedeemCode using RedeemTemplate
         */
        fun redeemCode(code: String, redeemTemplate: RedeemTemplate): RedeemCode {
            val currentTime = Timestamp.from(Instant.now())

            return RedeemCode(
                code = code.uppercase(),
                template = redeemTemplate.template,
                commands = redeemTemplate.commands,
                validFrom = currentTime,
                duration = redeemTemplate.duration,
                enabledStatus = true,
                redemption = redeemTemplate.redemption,
                playerLimit = redeemTemplate.playerLimit,
                permission = if (redeemTemplate.permissionRequired) redeemTemplate.permission.replace(
                    "{code}", code.lowercase()
                ) else "",
                pin = redeemTemplate.pin,
                sync = redeemTemplate.sync,
                usedBy = mutableMapOf(),
                target = mutableListOf(),
                lastRedeemed = mutableMapOf(),
                cooldown = "0s",
                modified = currentTime,
                rewards = redeemTemplate.rewards,
                sound = redeemTemplate.sound,
                messages = redeemTemplate.messages,
                ipLimit = mutableMapOf(),
                condition = redeemTemplate.condition,
                server = "Default"
            )
        }

        /**
         * Generate an empty RedeemCode
         **/
        fun redeemCode(code: String): RedeemCode {
            val currentTime = Timestamp.from(Instant.now())
            return RedeemCode(
                code = "",
                enabledStatus = true,
                template = "DEFAULT",
                sync = false,
                duration = "0s",
                cooldown = "0s",
                permission = "",
                pin = 0,
                redemption = 1,
                playerLimit = 1,
                usedBy = mutableMapOf(),
                validFrom = currentTime,
                lastRedeemed = mutableMapOf(),
                target = mutableListOf(),
                commands = mutableListOf(),
                rewards = mutableListOf(),
                messages = MessageState(
                    text = mutableListOf(), actionbar = "", title = JTitle()
                ),
                sound = SoundState(
                    sound = null, volume = 1f, pitch = 1f
                ),
                ipLimit = mutableMapOf(),
                condition = "",
                modified = currentTime,
                server = "Default"
            )
        }
    }

}