package api.justlime.redeemcodex.enums

sealed interface JGui {

    sealed interface Main : JGui {
        companion object {
            const val MAIN = "main"
            const val BACKGROUND = "${MAIN}.background"
            const val BACK_SLOT = "${MAIN}.slot.back"
            const val NEXT_SLOT = "${MAIN}.slot.next"
            const val PREV_SLOT = "${MAIN}.slot.prev"
            const val HOME_SLOT = "${MAIN}.slot.home"
        }

    }

    sealed interface Redeem: JGui{
        companion object {
            const val REDEEM_TITLE = "redeem-title"
            const val REDEEM_LABEL = "redeem-label"
            const val REDEEM_INPUT_ITEM = "redeem-input-item"
            const val REDEEM_OUTPUT_ITEM = "redeem-output-item"
            const val REDEEM_PIN_TITLE = "redeem-pin-title"
            const val REDEEM_PIN_LABEL = "redeem-pin-label"
            const val REDEEM_PIN_INPUT_ITEM = "redeem-pin-input-item"
            const val REDEEM_PIN_OUTPUT_ITEM = "redeem-pin-output-item"
        }
    }

    sealed interface HomeView : JGui {
        companion object {
            const val CODES = "codes"
            const val TEMPLATES = "templates"
            const val VOUCHERS = "vouchers"
        }
    }

    sealed interface CodeListView : JGui {
        companion object {
            const val CODE_ITEM = "code-item"
            const val CREATE = "create"
            const val SEARCH = "search"
            const val DELETE_CONFIRM = "delete-confirm"
        }
    }

    sealed interface TemplateListView : JGui {
        companion object {
            const val TEMPLATE_ITEM = "template-item"
            const val CREATE = "create"
            const val SEARCH = "search"
        }
    }

    sealed interface CodeEditorView : JGui {
        companion object {
            const val INFORMATION = "information"
            const val RESTRICTIONS = "restrictions"
            const val DURATIONS = "durations"
            const val MESSAGES = "messages"
            const val ENABLED = "enabled"
            const val DISABLED = "disabled"
            const val SYNCHRONIZER_ENABLED = "synchronizer-enabled"
            const val SYNCHRONIZER_DISABLED = "synchronizer-disabled"
            const val REWARDS = "rewards"
            const val COMMANDS = "commands"
        }
    }

    sealed interface TemplateEditorView : JGui {
        companion object {
            const val INFORMATION = "information"
            const val RESTRICTIONS = "restrictions"
            const val DURATIONS = "durations"
            const val MESSAGES = "messages"
            const val ENABLED = "enabled"
            const val DISABLED = "disabled"
            const val SYNCHRONIZER = "synchronizer"
            const val REWARDS = "rewards"
            const val COMMANDS = "commands"
        }
    }

    sealed interface CodeRewardsView : JGui {
        companion object {
            const val REWARD_ITEM = "reward-item"
            const val CREATE = "create"
        }
    }

    sealed interface TemplateRewardsView : JGui {
        companion object {
            const val REWARD_ITEM = "reward-item"
            const val CREATE = "create"
        }
    }

    sealed interface CodeCommandsView : JGui {
        companion object {
            const val COMMAND_ITEM = "command-item"
            const val CREATE = "create"
        }
    }

    sealed interface TemplateCommandsView : JGui {
        companion object {
            const val COMMAND_ITEM = "command-item"
            const val CREATE = "create"
        }
    }

    sealed interface CodeDurationView : JGui {
        companion object {
            const val COOLDOWN = "cooldown"
            const val EXPIRY = "expiry"
        }
    }

    sealed interface TemplateDurationView : JGui {
        companion object {
            const val COOLDOWN = "cooldown"
            const val EXPIRY = "expiry"
        }
    }

    sealed interface CodeMessagesView : JGui {
        companion object {
            const val CHAT = "chat"
            const val TITLE = "title"
            const val SUBTITLE = "subtitle"
            const val ACTIONBAR = "actionbar"
            const val SOUND = "sound"
        }
    }

    sealed interface TemplateMessagesView : JGui {
        companion object {
            const val CHAT = "chat"
            const val TITLE = "title"
            const val SUBTITLE = "subtitle"
            const val ACTIONBAR = "actionbar"
            const val SOUND = "sound"
        }
    }

    sealed interface CodeRestrictionView : JGui {
        companion object {
            const val REDEMPTION_LIMIT = "redemption-limit"
            const val PLAYER_LIMIT = "player-limit"
            const val PLAYER_LOCKED = "player-locked"
            const val PERMISSION = "permission"
            const val PIN = "pin"
            const val TARGET = "target"
        }
    }

    sealed interface CodeTargetsView : JGui {
        companion object {
            const val TARGET_ITEM = "target-item"
            const val CREATE = "create"
        }
    }

    sealed interface TemplateSynchronizerView : JGui {
        companion object {
            const val SYNC_ITEM = "sync-item"
        }
    }

    sealed interface CouponHistoryView : JGui {
        companion object {
            const val HISTORY_ITEM = "history-item"
            const val BACK = "back"
        }
    }

    sealed interface SoundsView : JGui {
        companion object {
            const val SOUND_ITEM = "sound-item"
        }
    }

    sealed interface Editor : JGui {
        companion object {
            const val SYNC_LOCKED_LORE = "sync-locked-lore"
            const val DELETE_CONFIRM = "delete-confirm"
            const val CREATE = "create"
            const val SAVE = "save"
        }
    }

    sealed interface Pages : JGui {
        companion object {
            const val SMALL_CAPS = "small-caps"
            const val AVAILABLE = "available"
            const val HISTORY = "history"
            const val BACKGROUND = "background"
        }
    }

    sealed interface Buttons : JGui {
        companion object {
            const val HOME = "home"
            const val BACK = "back"
            const val NEXT = "next"
            const val PREV = "prev"
        }
    }
}