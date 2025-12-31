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

sealed interface JMessage {
    companion object {
        const val PREFIX = "prefix"
        const val EMPTY_INPUT = "empty-input"
        const val REPORT = "report"
        const val TECHNICAL_ERROR = "technical-error"
    }

    sealed interface Redeem : JMessage {
        companion object {
            const val INVALID_CODE = "redeem-invalid-code"
            const val MAX_REDEMPTIONS = "redeem-max-redemptions"
            const val MAX_PLAYER_REDEEMED = "redeem-max-player-redeemed"
            const val DISABLED = "redeem-disabled"
            const val EXPIRED_CODE = "redeem-expired-code"
            const val INVALID_TARGET = "redeem-invalid-target"
            const val INVALID_CONDITION = "redeem-invalid-condition"
            const val MISSING_PIN = "redeem-missing-pin"
            const val INVALID_PIN = "redeem-invalid-pin"
            const val COMMAND_COOLDOWN = "redeem-command-cooldown"
            const val ON_COOLDOWN = "redeem-on-cooldown"
            const val FULL_INVENTORY = "redeem-full-inventory"
            const val NO_PERMISSION = "redeem-no-permission"
            const val SUCCESS = "redeem-success"
            const val FAILED = "redeem-failed"
            const val USAGE = "redeem-usage"
            const val INVALID_IP = "redeem-invalid-ip"
            const val FAILED_ADMIN = "redeem-failed-admin"
            const val PLAYER = "redeem-for-player"
            const val PLAYER_NOT_ONLINE = "redeem-player-not-online"
            const val COUPON_REMOVED = "redeem-coupon-removed"

        }

    }

    sealed interface Coupon: JMessage{
        companion object{
            const val NOT_FOUND = "coupon-not-found"
            const val EMPTY = "coupon-empty"
            const val ALREADY_EXIST = "coupon-already-exist"
            const val NOT_SHAREABLE = "coupon-not-shareable"
            const val EXPIRED = "coupon-expired"
            const val PLAYER_LIMIT_REACHED = "coupon-player-limit-reached"

            const val GIFT_CODE_PLAYER = "coupon-gift-code-player"
            const val SEND_CODE_PLAYER = "coupon-send-code-player"
            const val SEND_CODE_PLAYER_ALL = "coupon-send-code-player-all"
            const val SEND_CODE_PLAYER_ALL_ONLINE = "coupon-send-code-player-all-online"

            const val SEND_TEMPLATE_PLAYER = "coupon-send-template-player"
            const val SEND_TEMPLATE_PLAYER_ALL = "coupon-send-template-player-all"
            const val SEND_TEMPLATE_PLAYER_ALL_ONLINE = "coupon-send-template-player-all-online"

            const val SEND_CODE_PLAYER_NOT_SHAREABLE = "coupon-send-code-player-not-shareable"
            const val SEND_CODE_PLAYER_ALL_NOT_SHAREABLE = "coupon-send-code-player-all-not-shareable"
            const val SEND_CODE_PLAYER_ALL_ONLINE_NOT_SHAREABLE = "coupon-send-code-player-all-online-not-shareable"

            const val SEND_TEMPLATE_PLAYER_NOT_SHAREABLE = "coupon-send-template-player-not-shareable"
            const val SEND_TEMPLATE_PLAYER_ALL_NOT_SHAREABLE = "coupon-send-template-player-all-not-shareable"
            const val SEND_TEMPLATE_PLAYER_ALL_ONLINE_NOT_SHAREABLE = "coupon-send-template-player-all-online-not-shareable"


            const val RECEIVED_PLAYER = "coupon-received-player.{template}"
            const val RECEIVED_PLAYER_OFFLINE = "coupon-received-offline-player.{template}"
            const val RECEIVED_PLAYER_GIFT = "coupon-received-player-gift.{template}"
            const val RECEIVED_PLAYER_GIFT_OFFLINE = "coupon-received-player-gift-offline.{template}"

            const val REMOVE_CODE_PLAYER = "coupon-remove-code-player"
            const val REMOVE_CODE_ALL_ONLINE_PLAYER = "coupon-remove-code-all-online-player"
            const val REMOVE_CODE_ALL_PLAYER = "coupon-remove-code-all-player"
            const val REMOVE_ALL = "coupon-remove-all"
            const val REMOVE_ALL_PLAYER = "coupon-remove-all-player"
            const val REMOVE_ALL_ONLINE_PLAYER = "coupon-remove-all-online-player"

            const val REMOVE_TEMPLATE_PLAYER = "coupon-remove-template-player"
            const val REMOVE_TEMPLATE_ALL_PLAYER = "coupon-remove-template-all-player"
            const val REMOVE_TEMPLATE_ALL_ONLINE_PLAYER = "coupon-remove-template-all-online-player"

            const val TITLE_CLAIMED = "player-history-title"
            const val TITLE_AVAILABLE = "player-available-title"

            const val SELECTOR_ERROR = "coupon-command-selector-error"
            const val QUERYING_ALL_PLAYERS = "coupon-querying-all-players"
        }
    }

    sealed interface Code : JMessage {
        companion object {
            const val NOT_FOUND = "code-not-found"
            const val DISABLED = "code-disabled"
        }

        data object Placeholder {
            const val DISABLED = "code-placeholder-disabled"
            const val ENABLED = "code-placeholder-enabled"
        }

        data object Create : Code {
            const val SUCCESS = "code-create-success"
            const val FAILED = "code-create-failed"
            const val ALREADY_EXIST = "code-create-already-exist"
            const val MISSING = "code-create-missing"
            const val INVALID_AMOUNT = "code-create-invalid-amount"
            const val INVALID_LENGTH = "code-create-invalid-length"
            const val INVALID_RANGE = "code-create-invalid-range"
        }

        data object Edit : Code {
            const val SUCCESS = "code-modify-success"
            const val FAILED = "code-modify-failed"
            const val INVALID_VALUE = "code-modify-invalid-value"
            const val INVALID_ID = "code-modify-invalid-id"
            const val NOT_FOUND = "code-modify-not-found"

            const val SYNC = "code-modify-sync"
            const val SYNC_LOCKED = "code-modify-sync-locked"
            const val ENABLED_STATUS = "code-modify-enabled-status"
            const val SYNC_STATUS = "code-modify-sync-status"
            const val SET_TEMPLATE = "code-modify-set-template"

            const val SET_REDEMPTION = "code-modify-set-redemption"
            const val SET_REDEMPTION_INFINITE = "code-modify-set-redemption-infinite"

            const val SET_PLAYER_LIMIT = "code-modify-set-player-limit"
            const val SET_PLAYER_LIMIT_INFINITE = "code-modify-set-player-limit-infinite"

            const val SET_PIN = "code-modify-set-pin"
            const val CLEAR_PIN = "code-modify-clear-pin"

            const val SET_DURATION = "code-modify-set-duration"
            const val ADD_DURATION = "code-modify-add-duration"
            const val REMOVE_DURATION = "code-modify-remove-duration"

            const val SET_COOLDOWN = "code-modify-set-cooldown"
            const val CLEAR_COOLDOWN = "code-modify-clear-cooldown"
            const val SET_PERMISSION = "code-modify-set-permission"
            const val SET_PERMISSION_TEMPLATE = "code-modify-set-permission-template"
            const val CLEAR_PERMISSION = "code-modify-clear-permission"

            const val SET_TARGET = "code-modify-set-target"
            const val ADD_TARGET = "code-modify-add-target"
            const val REMOVE_TARGET = "code-modify-remove-target"
            const val TARGET_ALREADY_EXIST = "code-modify-target-already-exist"
            const val CLEAR_TARGET = "code-modify-clear-target"
            const val NOT_FOUND_TARGET = "code-modify-target-not-found"

            const val SET_COMMAND = "code-modify-set-command"
            const val ADD_COMMAND = "code-modify-add-command"
            const val REMOVE_COMMAND = "code-modify-remove-command"
            const val CLEAR_COMMAND = "code-modify-remove-all-command"

            const val SET_MESSAGE = "code-modify-set-message"
            const val ADD_MESSAGE = "code-modify-add-message"
            const val REMOVE_MESSAGE = "code-modify-remove-message"
            const val CLEAR_MESSAGE = "code-modify-clear-message"


            const val SET_ACTIONBAR = "code-modify-set-actionbar"
            const val CLEAR_ACTIONBAR = "code-modify-clear-actionbar"

            const val SET_TITLE = "code-modify-set-title"
            const val CLEAR_TITLE = "code-modify-clear-title"

            const val SET_SUBTITLE = "code-modify-set-subtitle"
            const val CLEAR_SUBTITLE = "code-modify-clear-subtitle"

            const val SET_SOUND = "code-modify-set-sound"
            const val CLEAR_SOUND = "code-modify-clear-sound"

            const val SET_CONDITION = "code-modify-set-condition"
            const val CLEAR_CONDITION = "code-modify-clear-condition"

        }

        data object Delete : Code {
            const val SUCCESS = "code-delete-success"
            const val FAILED = "code-delete-failed"
            const val SUCCESS_ALL = "code-delete-success-all"
            const val NOT_FOUND = "code-delete-not-found"
            const val NOT_FOUND_ALL = "code-delete-not-found-all"
            const val SUCCESS_CODES = "code-delete-success-codes"
            const val CONFIRMATION_NEEDED = "code-delete-confirmation-needed"
            const val DELETED_USING_TEMPLATE = "code-deleted-using-template"
            const val DELETED_EXPIRED_CODES = "code-delete-expired-codes"
            const val NO_EXPIRED_CODES = "code-delete-no-expired-codes"
        }

        data object Renew : Code {
            const val SUCCESS = "code-renew-success"
            const val SUCCESS_PLAYER = "code-renew-success-player"
            const val FAILED = "code-renew-failed"
            const val PLAYER_NOT_FOUND = "code-renew-player-not-found"
        }

        data object Preview : Code {
            const val PREVIEW = "code-preview"
        }

        data object Usages : Code {
            const val HEADING = "code-usage-heading"
            const val COMMAND = "code-usage-commands"
            const val TARGET = "code-usage-target-list"
            const val ENABLED = "code-usage-enabled"
            const val TEMPLATE = "code-usage-template"
            const val SYNC = "code-usage-sync"
            const val REDEMPTION = "code-usage-redemption"
            const val LIMIT = "code-usage-limit"
            const val PIN = "code-usage-pin"
            const val PERMISSION = "code-usage-permission"
            const val DURATION = "code-usage-duration"
            const val COOLDOWN = "code-usage-cooldown"
            const val REWARD_MESSAGE = "code-usage-reward-message"
            const val REWARD_TITLE = "code-usage-reward-title"
            const val REWARD_SUBTITLE = "code-usage-reward-subtitle"
            const val REWARD_ACTIONBAR = "code-usage-reward-actionbar"
            const val REWARD_SOUND = "code-usage-reward-sound"
            const val CONDITIONS = "code-usage-conditions"

        }

        data object Gui : JMessage {
            data object Save : JMessage {
                const val REWARDS = "code-gui-save-rewards"
            }
        }

        data object List : JMessage {
            const val LIST = "code-list"
        }


    }

    sealed interface Template : JMessage {

        companion object {
            const val NOT_FOUND = "template-not-found"
            const val DISABLED = "template-disabled"
        }

        data object Placeholder

        data object Generate : Template {
            const val SUCCESS = "template-create-success"
            const val ALREADY_EXIST = "template-create-already-exist"
        }

        data object Modify : Template {
            const val SUCCESS = "template-modify-success"
            const val FAILED = "template-modify-failed"
            const val SYNC_STATUS = "template-modify-sync-status"

            const val CODES_MODIFIED = "template-modify-codes-modified"
            const val INVALID_VALUE = "template-modify-invalid-value"
            const val INVALID_ID = "template-modify-invalid-id"
            const val NOT_FOUND = "template-modify-not-found"
            const val SET_PERMISSION = "template-modify-set-permission"
            const val CLEAR_PERMISSION = "template-modify-clear-permission"
            const val ENABLED_PERMISSION = "template-modify-enabled-permission"
            const val DISABLED_PERMISSION = "template-modify-disabled-permission"
            const val SET_DURATION = "template-modify-set-duration"

            const val SET_COOLDOWN = "template-modify-set-cooldown"
            const val CLEAR_COOLDOWN = "template-modify-clear-cooldown"

            const val SET_COMMAND = "template-modify-set-command"
            const val ADD_COMMAND = "template-modify-add-command"
            const val REMOVE_COMMAND = "template-modify-remove-command"
            const val CLEAR_COMMAND = "template-modify-remove-all-command"
            const val SET_DEFAULT_ENABLED_STATUS = "template-modify-default-enabled-status"

            const val SET_REDEMPTION = "template-modify-set-redemption"
            const val SET_REDEMPTION_INFINITE = "template-modify-set-redemption-infinite"

            const val SET_PLAYER_LIMIT = "template-modify-set-player-limit"
            const val SET_PLAYER_LIMIT_INFINITE = "template-modify-set-player-limit-infinite"

            const val SET_PIN = "template-modify-set-pin"
            const val CLEAR_PIN = "template-modify-clear-pin"


            const val SET_MESSAGE = "template-modify-set-message"
            const val ADD_MESSAGE = "template-modify-add-message"
            const val REMOVE_MESSAGE = "template-modify-remove-message"
            const val CLEAR_MESSAGE = "template-modify-clear-message"

            const val SET_ACTIONBAR = "template-modify-set-actionbar"
            const val CLEAR_ACTIONBAR = "template-modify-clear-actionbar"
            const val SET_TITLE = "template-modify-set-title"
            const val CLEAR_TITLE = "template-modify-clear-title"
            const val SET_SUBTITLE = "template-modify-set-subtitle"
            const val CLEAR_SUBTITLE = "template-modify-clear-subtitle"
            const val SET_SOUND = "template-modify-set-sound"
            const val CLEAR_SOUND = "template-modify-clear-sound"

            const val SET_CONDITION = "template-modify-set-condition"
            const val CLEAR_CONDITION = "template-modify-clear-condition"

        }

        data object Delete : Template {
            const val SUCCESS = "template-delete-success"
            const val SUCCESS_ALL = "template-delete-success-all"
            const val NOT_FOUND = "template-delete-not-found"
            const val CONFIRMATION_NEEDED = "template-delete-confirmation-needed"
            const val FAILED_DEFAULT = "template-delete-default-delete"
        }

        data object Usage : Template {
            const val HEADING = "template-usage-heading"
            const val ENABLED = "template-usage-enabled"
            const val SYNC = "template-usage-syn"
            const val REDEMPTION = "template-usage-redemption"
            const val LIMIT = "template-usage-limit"
            const val PIN = "template-usage-pin"
            const val PERMISSION = "template-usage-permission"
            const val DURATION = "template-usage-duration"
            const val COOLDOWN = "template-usage-cooldown"
            const val REWARD_MESSAGE = "template-usage-reward-message"
            const val REWARD_TITLE = "template-usage-reward-title"
            const val REWARD_SUBTITLE = "template-usage-reward-subtitle"
            const val REWARD_ACTIONBAR = "template-usage-reward-actionbar"
            const val REWARD_SOUND = "template-usage-reward-sound"
            const val COMMANDS = "template-usage-commands"
            const val TARGET = "template-usage-target-list"
            const val CONDITIONS = "template-usage-conditions"
        }

        data object Preview : Code {
            const val PREVIEW = "template-preview"
        }

        data object Gui : JMessage {
            data object Save : JMessage {
                const val REWARDS = "template-gui-save-rewards"
            }
        }

        data object List : JMessage {
            const val LIST = "template-list"
        }
    }

    sealed interface Command : JMessage {
        companion object {
            const val RESTRICTED_TO_PLAYERS = "commands.restricted-to-players"
            const val INVALID_USAGE = "commands.invalid-usage"
            const val PLAYER_NOT_FOUND = "commands.player-not-found"
            const val NO_PERMISSION = "commands.no-permission"
            const val UNKNOWN_COMMAND = "commands.unknown-command"
            const val INFO = "commands.info"

        }

        data object Help : Command {
            const val GENERAL = "commands.help.general"
            const val REDEEM = "commands.help.redeem"
            const val GENERATION = "commands.help.generation"
            const val MODIFICATION = "commands.help.modification"
            const val DELETION = "commands.help.deletion"
            const val RENEWAL = "commands.help.renewal"
            const val PREVIEW = "commands.help.preview"
            const val USAGE = "commands.help.usage"
            const val RELOAD = "commands.help.reload"
            const val PERMISSIONS = "commands.help.permissions"
            const val PROPERTIES = "commands.help.properties"
        }

        data object Renew : Command {
            const val SUCCESS = "commands.renew.success"
            const val INVALID_SYNTAX = "commands.renew.invalid-syntax"
            const val EXPIRED_CODE = "commands.renew.expired-code"
            const val FAILED = "commands.renew.failed"
            const val PLAYER_NOT_FOUND = "commands.renew.player-not-found"
        }

        data object Reload : Command {
            const val SUCCESS = "commands.reload.success"
            const val FAILED = "commands.reload.failed"
        }

    }

    sealed interface Console : JMessage {
        data object Extra : Console {
            const val DELETED_EXPIRED_CODES = "console.deleted-expired-codes"

        }
    }

    sealed interface Log : JMessage {

        data object Redeem : Log {
            const val CODE = "format.redeem.code"
            const val CODE_DISCORD = "format.redeem.{template}"
            const val TEMPLATE = "format.redeem.template"
        }

        data object Renew : Log {
            const val CODE = "format.renew.code"
        }

        data object Create : Log {
            const val CODE = "format.create.code"
            const val TEMPLATE = "format.create.template"
        }

        sealed interface Edit : Log {
            companion object {
                const val CODE = "format.edit.code"
                const val TEMPLATE = "format.edit.template"
            }
            data object Property : Log {
                // General Settings
                const val ENABLED = "format.edit.property.enabled"
                const val SYNC = "format.edit.property.sync"
                const val REDEMPTION = "format.edit.property.redemption"
                const val LIMIT = "format.edit.property.limit"

                // Commands
                const val ADD_COMMAND = "format.edit.property.addCommand"
                const val REMOVE_COMMAND = "format.edit.property.removeCommand"
                const val SET_COMMAND = "format.edit.property.setCommand"

                // Durations
                const val ADD_DURATION = "format.edit.property.addDuration"
                const val REMOVE_DURATION = "format.edit.property.removeDuration"
                const val SET_DURATION = "format.edit.property.setDuration"

                // Permissions & Security
                const val PERMISSION = "format.edit.property.permission"
                const val REQUIRED_PERMISSION = "format.edit.property.requiredPermission"
                const val PIN = "format.edit.property.pin"

                // Targets
                const val SET_TARGET = "format.edit.property.setTarget"
                const val ADD_TARGET = "format.edit.property.addTarget"
                const val REMOVE_TARGET = "format.edit.property.removeTarget"
                const val LIST_TARGET = "format.edit.property.listTarget"

                // Template & Cooldown
                const val SET_TEMPLATE = "format.edit.property.template"
                const val SET_COOLDOWN = "format.edit.property.cooldown"

                // Messages
                const val ADD_MSG = "format.edit.property.addMessage"
                const val REMOVE_MSG = "format.edit.property.removeMessage"
                const val SET_MSG = "format.edit.property.setMessage"

                // Visuals & Sounds
                const val ACTION_BAR_MSG = "format.edit.property.actionbar"
                const val TITLE_MSG = "format.edit.property.title"
                const val SUBTITLE_MSG = "format.edit.property.subtitle"
                const val SOUND = "format.edit.property.sound"

                // Conditions & Rewards
                const val CONDITION = "format.edit.property.condition"
                const val REWARD = "format.edit.property.rewards"

                // GUI Interactions
                const val RESTRICTION_GUI = "format.edit.property.restrictions"
                const val DURATION_GUI = "format.edit.property.durations"
                const val COMMAND_GUI = "format.edit.property.commands"
                const val MESSAGE_GUI = "format.edit.property.messages"
            }
        }

        data object Update : Log {
            const val CODE = "format.update.code"
            const val CODES = "format.update.code"
            const val TEMPLATE = "format.update.template"
        }

        data object Delete : Log {
            const val CODE = "format.delete.code"
            const val TEMPLATE = "format.delete.template"
        }

        data object Preview : Log {
            const val CODE = "format.preview.code"
            const val TEMPLATE = "format.preview.template"
        }

        data object Give : Log {
            const val COUPON = "format.give.coupon"
        }

        data object Gift : Log {
            const val COUPON = "format.gift.coupon"
        }

        data object Take : Log {
            const val COUPON = "format.take.coupon"
        }

        data object Consume : Log {
            const val COUPON = "format.consume.coupon"
        }
    }

}
