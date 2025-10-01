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

import api.justlime.redeemcodex.RedeemXAPI
import api.justlime.redeemcodex.enums.RedeemCategory
import org.bukkit.inventory.ItemStack

data class RedeemTemplate(
    override var redeemCategory: RedeemCategory = RedeemCategory.RedeemTemplate,
    override val template: String,
    var digit: Int = 5,

    override var enabledStatus: Boolean,
    var syncEnabledStatus: Boolean,

    override var commands: MutableList<String>,
    var syncCommands: Boolean,

    override var duration: String,
    var syncDuration: Boolean,

    override var cooldown: String,
    var syncCooldown: Boolean,

    override var pin: Int = 0,
    var syncPin: Boolean,

    override var redemption: Int = 1,
    var syncRedemption: Boolean,

    override var playerLimit: Int = 1,
    var syncPlayerLimit: Boolean,

    override var sync: Boolean,
    var syncLockedStatus: Boolean,

    override var permission: String,
    var permissionRequired: Boolean,
    var syncPermission: Boolean,

    override var messages: MessageState,
    var syncMessages: Boolean,

    override var sound: SoundState,

    var syncSound: Boolean,

    override var rewards: MutableList<ItemStack>,
    var syncRewards: Boolean,

    override var condition: String,
    var syncCondition: Boolean,
) : RedeemType {
    object Create {
        fun redeemTemplate(template: String): RedeemTemplate {
            if (RedeemXAPI.template.isTemplateExist(template)) {
                throw IllegalStateException("TEMPLATE ALREADY EXIST")
            }
            val template = loadDefaultTemplateValues(template)
            template.sync = true
            RedeemXAPI.template.upsertTemplate(template)
            return template
        }

        private fun loadDefaultTemplateValues(template: String): RedeemTemplate {
            return RedeemTemplate(
                template = template,
                enabledStatus = true,
                commands = mutableListOf(),
                duration = "0s",
                cooldown = "0s",
                redemption = 1,
                playerLimit = 1,
                sync = false,
                permissionRequired = false,
                permission = "redeemx.use.${template.lowercase()}.{code}",
                condition = "",
                messages = MessageState(mutableListOf(), "", JTitle()),
                sound = SoundState(),
                pin = -1,
                rewards = mutableListOf(),
                syncEnabledStatus = true,
                syncLockedStatus = true,
                syncCommands = true,
                syncDuration = true,
                syncCooldown = true,
                syncPin = true,
                syncRedemption = true,
                syncPlayerLimit = true,
                syncPermission = true,
                syncMessages = true,
                syncSound = true,
                syncRewards = true,
                syncCondition = true
            )
        }
    }

}
