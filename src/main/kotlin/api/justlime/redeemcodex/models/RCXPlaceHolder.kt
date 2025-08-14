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
import api.justlime.redeemcodex.utilities.JTimeUtils
import org.bukkit.command.CommandSender
import kotlin.code
import kotlin.toString

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
    var condition: String = "none",

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

    var dateFormat: String = "yyyy-MM-dd HH:mm:ss"
) {
    companion object {
        fun fetchByDB(code: String, sender: CommandSender): RCXPlaceHolder {
            val redeemCode: RedeemCode = RedeemXAPI.code.getCode(code) ?: return RCXPlaceHolder(sender, code = code)

            val durationSeconds = redeemCode.duration.removeSuffix("s").toIntOrNull() ?: 0
            val days = durationSeconds / 86400
            val hours = (durationSeconds % 86400) / 3600
            val minutes = (durationSeconds % 3600) / 60
            val seconds = durationSeconds % 60

            val formattedDuration = buildString {
                if (days > 0) append("${days}d ")
                if (hours > 0) append("${hours}h ")
                if (minutes > 0) append("${minutes}m ")
                if (seconds > 0 || isEmpty()) append("${seconds}s")
            }.trim()

            return RCXPlaceHolder(
                sender = sender,
                code = code,
                command = redeemCode.commands.toString().removeSurrounding("{", "}").trim(),
                duration = if (redeemCode.duration.isEmpty()) "none" else formattedDuration,
                status = redeemCode.enabledStatus.toString(),
                redemptionLimit = redeemCode.redemption.toString(),
                playerLimit = redeemCode.playerLimit.toString(),
                permission = redeemCode.permission,
                pin = if (redeemCode.pin <= 0) "none" else redeemCode.pin.toString(),
                target = redeemCode.target.toString(),
                usedBy = redeemCode.usedBy.toString(),
                template = redeemCode.template,
                templateSync = redeemCode.sync.toString(),
                cooldown = redeemCode.cooldown,
                isExpired = JTimeUtils.isExpired(redeemCode).toString(),
                minLength = "3",
                maxLength = "25",
                codeGenerateDigit = "5",
                chatMessage = redeemCode.messages.text.toString().removeSurrounding("[", "]").trim(),
                chatTitle = redeemCode.messages.title.title,
                chatSubTitle = redeemCode.messages.title.subTitle,
                chatTitleFadeIn = redeemCode.messages.title.fadeIn,
                chatTitleFadeOut = redeemCode.messages.title.fadeOut,
                chatTitleStay = redeemCode.messages.title.stay,
                chatActionBar = redeemCode.messages.actionbar,
                sound = redeemCode.sound.sound.toString(),
                soundVolume = redeemCode.sound.volume,
                soundPitch = redeemCode.sound.pitch,
            )
        }

        fun applyByRedeemCode(redeemCode: RedeemCode, sender: CommandSender): RCXPlaceHolder {
            return RCXPlaceHolder(
                sender = sender,
                code = redeemCode.code,
                template = redeemCode.template,
                duration = redeemCode.duration,
                status = redeemCode.enabledStatus.toString(),
                redemptionLimit = redeemCode.redemption.toString(),
                playerLimit = redeemCode.playerLimit.toString(),
                permission = redeemCode.permission,
                pin = if (redeemCode.pin <= 0) "none" else redeemCode.pin.toString(),
                target = redeemCode.target.toString(),
                usedBy = redeemCode.usedBy.map {
                    "${it.key} = ${it.value}"
                }.joinToString(", "),
                templateSync = redeemCode.sync.toString(),
                cooldown = redeemCode.cooldown,
                minLength = "none",
                maxLength = "none",
                codeGenerateDigit = "3",
                isExpired = JTimeUtils.isExpired(redeemCode).toString(),
                command = redeemCode.commands.toString().removeSurrounding("[", "]").trim(),
                chatMessage = redeemCode.messages.text.toString().removeSurrounding("[", "]").trim(),
                chatTitle = redeemCode.messages.title.title,
                chatSubTitle = redeemCode.messages.title.subTitle,
                chatTitleFadeIn = redeemCode.messages.title.fadeIn,
                chatTitleFadeOut = redeemCode.messages.title.fadeOut,
                chatTitleStay = redeemCode.messages.title.stay,
                chatActionBar = redeemCode.messages.actionbar,
                sound = redeemCode.sound.sound.toString(),
                soundVolume = redeemCode.sound.volume,
                soundPitch = redeemCode.sound.pitch,
                condition = redeemCode.condition
            )
        }

        fun applyByRedeemTemplate(template: RedeemTemplate, sender: CommandSender): RCXPlaceHolder {
            return RCXPlaceHolder(
                sender = sender,
                template = template.template,
                status = template.enabledStatus.toString(),
                templateSync = template.sync.toString(),
                duration = template.duration,
                cooldown = template.cooldown,
                redemptionLimit = template.redemption.toString(),
                playerLimit = template.playerLimit.toString(),
                permission = template.permission,
                pin = if (template.pin <= 0) "none" else template.pin.toString(),
                minLength = "none",
                maxLength = "none",
                codeGenerateDigit = "none",
                command = template.commands.toString().removeSurrounding("[", "]").trim(),
                chatMessage = template.messages.text.toString().removeSurrounding("[", "]").trim(),
                chatTitle = template.messages.title.title,
                chatSubTitle = template.messages.title.subTitle,
                chatTitleFadeIn = template.messages.title.fadeIn,
                chatTitleFadeOut = template.messages.title.fadeOut,
                chatTitleStay = template.messages.title.stay,
                chatActionBar = template.messages.actionbar,
                sound = template.sound.sound ?: "None",
                soundVolume = template.sound.volume,
                soundPitch = template.sound.pitch,
                condition = template.condition
            )
        }

        //warp to map

    }

    private fun rcxPlaceholderMap(): Map<String, String> {
        val placeholder = this
        return mapOf(

            //Main
            "player" to placeholder.sender.name,
            "args" to placeholder.args.joinToString(" "),
            "property" to placeholder.property,
            "current_version" to placeholder.currentVersion,
            "author" to placeholder.author,
            "DATE" to placeholder.dateFormat,
            "code" to placeholder.code,
            "template" to placeholder.template,

            //Redeem Command
            "command_cooldown" to placeholder.commandCooldown,
            "cooldown" to placeholder.cooldown,
            "min" to placeholder.minLength,
            "max" to placeholder.maxLength,

            //Code Info
            "player_redeemed" to placeholder.totalPlayerUsage,
            "total_code" to placeholder.totalCodes.toString(),
            "total_redemption" to placeholder.totalRedemption,
            "target" to placeholder.target,
            "expired" to placeholder.isExpired,
            "expiry" to placeholder.validTo,
            "redeemed_by" to placeholder.redeemedBy,
            "usedBy" to placeholder.usedBy,
            "code_cooldown" to placeholder.codeCooldown,

            //Template
            "digit" to placeholder.codeGenerateDigit,
            "{required_permission}" to placeholder.requiredPermission,
            "sync_property" to placeholder.templateSyncProperty,
            "sync_value" to placeholder.templateSync,
            "sync" to placeholder.templateSync,


            //Common
            "max_redemption" to placeholder.redemptionLimit,
            "max_player_limit" to placeholder.playerLimit,
            "duration" to placeholder.duration,
            "condition" to placeholder.condition,
            "pin" to placeholder.pin,
            "permission" to placeholder.permission,
            "command" to placeholder.command,
            "id" to placeholder.commandId,
            "reward_message" to placeholder.chatMessage,
            "reward_message_id" to placeholder.chatMessageID.toString(),
            "reward_actionbar" to placeholder.chatActionBar,
            "reward_title" to placeholder.chatTitle,
            "reward_subtitle" to placeholder.chatSubTitle,
            "reward_fade_in" to placeholder.chatTitleFadeIn.toString(),
            "reward_stay" to placeholder.chatTitleStay.toString(),
            "reward_fade_out" to placeholder.chatTitleFadeOut.toString(),
            "sound" to placeholder.sound,
            "sound_volume" to placeholder.soundVolume.toString(),
            "sound_pitch" to placeholder.soundPitch.toString(),

            //Output
            "renewed_player" to placeholder.renewedPlayer,
            "status" to placeholder.status,

            )

    }

    fun toMap(): Map<String, String> {
        return rcxPlaceholderMap()
    }


}