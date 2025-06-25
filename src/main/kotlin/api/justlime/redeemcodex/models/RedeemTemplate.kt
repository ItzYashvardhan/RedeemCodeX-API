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

import org.bukkit.inventory.ItemStack

data class RedeemTemplate(
    val name: String, //TODO Implement Template Rename

    var defaultEnabledStatus: Boolean,
    var syncEnabledStatus: Boolean,

    var commands: MutableList<String>,
    var syncCommands: Boolean,

    var duration: String,
    var syncDuration: Boolean,

    var cooldown: String,
    var syncCooldown: Boolean,

    var pin: Int = 0,
    var syncPin: Boolean,

    var redemption: Int = 1,
    var syncRedemption: Boolean,

    var playerLimit: Int = 1,
    var syncPlayerLimit: Boolean,

    var defaultSync: Boolean,
    var syncLockedStatus: Boolean,

    var permissionRequired: Boolean,
    var permissionValue: String,
    var syncPermission: Boolean,

    var messages: MessageState,
    var syncMessages: Boolean,

    var sound: String,
    var soundVolume: Float,
    var soundPitch: Float,

    var syncSound: Boolean,

    var rewards: MutableList<ItemStack>,
    var syncRewards: Boolean,

    var target: MutableList<String> = mutableListOf(),
    var syncTarget: Boolean,
    var condition: String
)
