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

sealed interface JTab {

    enum class GeneralActions(val value: String) {
        Create("create"),

        Edit("edit"),

        Delete("delete"),

        About("about"),

        Reload("reload"),

        Preview("preview"),

        Usage("usage"),

        Renew("renew"),

        Help("help"),

        List("list"),

        Coupon("coupon"),

        Vacuum("vacuum")

    }

    sealed interface Type {
        companion object {
            const val CODE = "code"
            const val TEMPLATE = "template"
        }
    }

    sealed interface Extra {
        companion object {
            const val DELETE_EXPIRED_CODES = "expiry"
            const val PLAYER_REDEEMED_CODES = "player"
        }
    }

    sealed interface Generate {
        companion object {
            const val CUSTOM = "CUSTOM"
            const val AMOUNT = "AMOUNT"
            const val DIGIT = "DIGIT"
            const val TEMPLATE_NAME = "TEMPLATE_NAME"
        }
    }

    sealed interface Edit {
        companion object {
            const val ENABLED = "enabled"
            const val SYNC = "sync"
            const val SET_REDEMPTION = "redemption"
            const val SET_PLAYER_LIMIT = "limit"

            const val ADD_COMMAND = "addCommand"
            const val REMOVE_COMMAND = "removeCommand"
            const val SET_COMMAND = "setCommand"

            const val ADD_DURATION = "addDuration"
            const val REMOVE_DURATION = "removeDuration"
            const val SET_DURATION = "setDuration"

            const val SET_PERMISSION = "permission"
            const val REQUIRED_PERMISSION = "requiredPermission"
            const val SET_PIN = "pin"

            const val SET_TARGET = "setTarget"
            const val ADD_TARGET = "addTarget"
            const val REMOVE_TARGET = "removeTarget"
            const val LIST_TARGET = "listTarget"

            const val SET_TEMPLATE = "template"
            const val SET_COOLDOWN = "cooldown"

            const val ADD_MSG = "addMessage"
            const val REMOVE_MSG = "removeMessage"
            const val SET_MSG = "setMessage"

            const val SET_ACTION_BAR_MSG = "actionbar"
            const val SET_TITLE_MSG = "title"
            const val SET_SUBTITLE_MSG = "subtitle"
            const val SET_SOUND = "sound"

            const val SET_CONDITION = "condition"

            const val REWARD = "rewards"

            const val RESTRICTION_GUI = "restrictions"
            const val DURATION_GUI = "durations"
            const val COMMAND_GUI = "commands"
            const val MESSAGE_GUI = "messages"

        }

    }

    sealed interface Player {
        companion object {
            const val GIVE = "give"
            const val TAKE = "take"
            const val HISTORY = "history"
            const val VIEW = "view"
        }
    }

    sealed interface Coupons {
        companion object {
            const val VIEW = "view"
            const val HISTORY = "history"
            const val GIFT = "gift"
        }
    }

    enum class Boolean(val value: String) {
        True("true"), False("false")
    }

    enum class Delete(val value: String) {
        All("*"), Confirm("CONFIRM"), Last("LAST"),
    }
}
