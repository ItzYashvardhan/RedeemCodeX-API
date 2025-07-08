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


import org.bukkit.command.CommandSender

data class RCXPlaceHolder(
    var sender: CommandSender,
    val args: List<String> = emptyList(),

    var code: String = "none",
    var totalCodes: Int = 1,
    var template: String = "none",
    var command: String = "none",
    var commandId: String = "none",
    var duration: String = "none",
    var status: String = "none",
    var renewedPlayer: String = "none",

    var permission: String = "none",
    var requiredPermission: String = "none",
    var pin: String = "none",
    var target: String = "none",
    var cooldown: String = "none",
    var codeCooldown: String = "none",
    var commandCooldown: String = "none",
    val isExpired: String = "none",
    var minLength: String = "none",
    var maxLength: String = "none",
    var codeGenerateDigit: String = "none",
    var property: String = "none",

    var redemptionLimit: String = "none",
    var playerLimit: String = "none",
    var usedBy: String = "none",
    var redeemedBy: String = "none",
    var totalPlayerUsage: String = "none",
    var totalRedemption: String = "none",

    var validTo: String = "none",
    var validFrom: String = "none",
    var lastRedeemed: String = "none",

    var chatMessage: String = "",
    var chatMessageID: Int = 0,
    var chatActionBar: String = "",
    var chatTitle: String = "",
    var chatSubTitle: String = "",
    var chatTitleFadeIn: Long = 0,
    var chatTitleFadeOut: Long = 0,
    var chatTitleStay: Long = 0,
    var sound: String = "None",
    var soundVolume: Float = 0f,
    var soundPitch: Float = 0f,

    var currentVersion: String = "1.0.0",
    var author: String = "JustLime",

    var templateSync: String = "none",
    var templateSyncProperty: String = "none",
)