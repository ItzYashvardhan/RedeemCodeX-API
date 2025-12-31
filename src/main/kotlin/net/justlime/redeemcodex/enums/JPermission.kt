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



package net.justlime.redeemcodex.enums

sealed interface JPermission {
    data object Admin : JPermission {
        private const val USE = "redeemx.admin"
        const val EDITOR = "$USE.editor"
        const val CREATE = "$USE.create"
        const val MODIFY = "$USE.modify"
        const val DELETE = "$USE.delete"
        const val PREVIEW = "$USE.preview"
        const val INFO = "$USE.info"
        const val RENEW = "$USE.renew"
        const val RELOAD = "$USE.reload"
        const val USAGE = "$USE.usage"
        const val HELP = "$USE.help"
        const val COUPON = "$USE.coupon"

        const val VACUUM = "$USE.vacuum"
        const val LIST = "$USE.list"
        const val TAB_CODES = "$USE.tab.codes"
        const val TAB_TEMPLATES = "$USE.tab.templates"
        const val REDEEM_TAB_CODES = "$USE.redeem.tab.codes"
        const val ALL = "$USE.*"
    }

    data object Player : JPermission {
        const val USE = "redeemx.use"
    }

    data object Coupons: JPermission{
        const val GIFT = "redeemx.coupons.gift"
        const val VIEW = "redeemx.coupons.view"
    }

    data object Bypass : JPermission {
        const val COMMAND_COOLDOWN = "redeemx.bypass.command.cooldown"
        const val CODE_COOLDOWN = "redeemx.bypass.code.cooldown.*"
        const val INDIVIDUAL_CODE_COOLDOWN = "redeemx.bypass.code.cooldown.{code}"
        const val TEMPLATE_COOLDOWN = "redeemx.bypass.template.cooldown.{template}"
        const val PIN = "redeemx.bypass.pin"
        const val REDEMPTION = "redeemx.bypass.redemption"
        const val LIMIT = "redeemx.bypass.limit"
        const val CONDITION = "redeemx.bypass.condition"
        const val EXPIRY = "redeemx.bypass.expiry"
        const val IP = "redeemx.bypass.ip"
        const val TARGET = "redeemx.bypass.target"
        const val PERMISSION = "redeemx.bypass.permission"

        const val ALL = "redeemx.bypass.*"
    }

}