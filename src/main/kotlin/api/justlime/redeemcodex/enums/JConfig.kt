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



package api.justlime.redeemcodex.enums

sealed interface JConfig {

    companion object {
        const val LANG = "lang"
    }

    data object Code : JConfig {
        private const val CODE = "code"
        const val DISPLAY_AMOUNT = "$CODE.display-amount"
        const val MINIMUM_DIGIT = "$CODE.minimum-digit"
        const val MAXIMUM_DIGIT = "$CODE.maximum-digit"
    }

    data object Removal : JConfig {
        private const val REMOVAL = "auto-delete"
        const val EXPIRED_CODES = "$REMOVAL.expired-codes"
        const val REDEEMED_CODES = "$REMOVAL.redeemed-codes"
    }

    data object Redeem : JConfig {
        private const val REDEEM = "redeem-command"
        const val COOLDOWN = "$REDEEM.cooldown"
        const val PREVENT_ALT_ACCOUNT = "$REDEEM.prevent-alt-account"
        const val ALIASES = "$REDEEM.aliases"
        const val TAB_CODES = "$REDEEM.tab-codes"
        const val GUI_ENABLED = "$REDEEM.gui.enabled"
    }

    data object RCX : JConfig {
        private const val RCX = "rcx-command"
        const val ALIASES = "$RCX.aliases"
        const val GUI_ENABLED = "$RCX.gui.enabled"
    }

    data object Coupons : JConfig {
        private const val COUPONS = "coupons-command"
        const val ALIASES = "$COUPONS.aliases"
        const val GUI_ENABLED = "$COUPONS.gui.enabled"
    }

    data object Rewards : JConfig {
        private const val REWARDS = "rewards"
        const val DROP = "$REWARDS.drop"
        const val SOUND = "$REWARDS.sound"
        const val AUTO_EQUIP_ARMOR = "$REWARDS.equip-armor"

    }

    data object License : JConfig {
        const val LICENSE_KEY = "license-key"
//        const val LICENSE_SECRET = "%%__LICENSE__%%"
        const val LICENSE_SECRET = "4aa575a8-02fa-4b7d-b6ed-3cd2495339bf"

    }

    data object Renew : JConfig {
        private const val RENEW = "renew"
        const val RESET_EXPIRED = "$RENEW.reset-expired"
        const val RESET_DELAY = "$RENEW.reset-delay"
        const val CLEAR_USAGE = "$RENEW.clear-usage"
        const val CLEAR_REWARDS = "$RENEW.clear-rewards"
        const val CLEAR_COMMANDS = "$RENEW.clear-commands"
        const val REMOVE_PERMISSION_REQUIRED = "$RENEW.remove-permission-required"

    }

    data object Logger : JConfig {
        private const val LOGGER = "logger"
        const val GENERATE = "$LOGGER.generate"
        const val MODIFY = "$LOGGER.modify"
        const val DELETE = "$LOGGER.delete"
        const val REDEEM = "$LOGGER.redeem"
        const val PREVIEW = "$LOGGER.preview"
        const val RENEW = "$LOGGER.renew"
        const val WEBHOOK_ENABLED = "$LOGGER.webhook.enabled"
        const val WEBHOOK_URL = "$LOGGER.webhook.url"
        const val WEBHOOK_URL_DEFAULT = "$LOGGER.webhook.url.default"
        const val WEBHOOK_URL_GENERATE = "$LOGGER.webhook.url.generate"
        const val WEBHOOK_URL_MODIFY = "$LOGGER.webhook.url.modify"
        const val WEBHOOK_URL_DELETE = "$LOGGER.webhook.url.delete"
        const val WEBHOOK_URL_REDEEM = "$LOGGER.webhook.url.redeem"
        const val WEBHOOK_URL_PREVIEW = "$LOGGER.webhook.url.preview"
        const val WEBHOOK_URL_RENEW = "$LOGGER.webhook.url.renew"
        const val ONLY_EMBED = "$LOGGER.only-embed"
        const val ONLY_EMBED_DEFAULT = "$LOGGER.only-embed.default"
        const val ONLY_EMBED_REDEEM = "$LOGGER.only-embed.redeem"
        const val ONLY_EMBED_GENERATE = "$LOGGER.only-embed.generate"
        const val ONLY_EMBED_DELETE = "$LOGGER.only-embed.delete"
        const val ONLY_EMBED_PREVIEW = "$LOGGER.only-embed.preview"
        const val ONLY_EMBED_RENEW = "$LOGGER.only-embed.renew"

    }

    data object Database : JConfig {
        const val SERVER = "database.server"
        const val TYPE = "database.type"
        const val HOST = "database.mysql.host"
        const val PORT = "database.mysql.port"
        const val NAME = "database.mysql.name"
        const val USERNAME = "database.mysql.username"
        const val PASSWORD = "database.mysql.password"
        const val ADDITIONAL_OPTIONS = "database.mysql.additional-options"
        const val MAXIMUM_POOL_SIZE = "database.maximum-pool-size"
        const val LEAK_DETECTION_THRESHOLD = "database.leak-detection-threshold"
        const val CONNECTION_TIMEOUT = "database.connection-timeout"
        const val IDLE_TIMEOUT = "database.idle-timeout"
        const val MAX_LIFETIME = "database.max-lifetime"
        const val DEBUGGING = "database.debugging"
        const val VERSION = "database.version"

    }

}