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

sealed interface JDatabase {
    companion object Database {
        const val NAME = "redeemx.db"
    }

    enum class Type {
        MYSQL, SQLITE
    }

    sealed interface Table {
        companion object Table {
            const val REDEEM_CODES = "redeem_codes"
            const val REDEEM_COUPONS = "redeem_coupons"
            const val REDEEM_LOG = "redeem_log"
            const val COUPON_NOTIFICATIONS = "coupon_notifications"
        }
    }

    enum class CodeProperty(val property: String) {
        CODE("code"), ENABLED("enabled"),
        TEMPLATE("template"), SYNC("sync"),
        DURATION("duration"),
        COOLDOWN("cooldown"),
        PERMISSION("permission"),
        PIN("pin"),
        REDEMPTION("redemption"),
        PLAYER_LIMIT("playerLimit"),
        USED_BY("usedBy"),
        VALID_FROM("validFrom"),
        LAST_REDEEMED("lastRedeemed"),
        TARGET("target"),
        COMMANDS("commands"),
        REWARDS("rewards"),
        Message("messages"),
        Sound("sound"),
        IpLimit("ip"),
        Condition("code_conditions"),
        MODIFIED("modified"), //Last Modified at
        Server("server")
    }

    enum class CouponProperty(val property: String) {
        ID("id"),
        PLAYER_UUID("player_uuid"),
        CODE("code"),
        TEMPLATE("template"),
        GIFTABLE("giftable"),
        GIFTED_AT("gifted_at"),
        SENDER("sender"),
        Server("server")
    }

    enum class LogProperty(val property: String){
        ID("id"),
        PLAYER_UUID("player_uuid"),
        CODE("code"),
        TEMPLATE("template"),
        REDEEMED_AT("redeemed_at"),
        Server("server")
    }

    enum class NotificationProperty(val property: String) {
        ID("id"),
        UUID("uuid"),
        COUPON_CODE("coupon_code"),
        TEMPLATE("template"),
        GIFTED("gifted"),
        SENDER("sender"),
        Server("server")
    }

}