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

enum class JFiles(val filename: String) {
    CONFIG("config.yml"),
    COUPONS("coupons.yml"),
    MESSAGES("lang/en/messages.yml"),
    TEMPLATE("template.yml"),
    WEBHOOK("webhook.yml"),
    GUI_PAGES("lang/en/gui/pages.yml"),
    GUI_BUTTONS("lang/en/gui/buttons.yml"),
    GUI_EDITOR("lang/en/gui/editor.yml"),
    GUI_REDEEM("lang/en/gui/redeem.yml"),
    GUI_COUPON("lang/en/gui/coupons/coupon_view.yml"),
    GUI_FONT("font.yml"),
    GUI_HOME("lang/en/gui/home_view.yml"),
    GUI_CODE_LIST("lang/en/gui/codes/code_list_view.yml"),
    GUI_TEMPLATE_LIST("lang/en/gui/templates/template_list_view.yml"),
    GUI_CODE_EDITOR("lang/en/gui/codes/code_editor_view.yml"),
    GUI_TEMPLATE_EDITOR("lang/en/gui/templates/template_editor_view.yml"),
    GUI_CODE_REWARDS("lang/en/gui/codes/code_rewards_view.yml"),
    GUI_TEMPLATE_REWARDS("lang/en/gui/templates/template_rewards_view.yml"),
    GUI_CODE_COMMANDS("lang/en/gui/codes/code_commands_view.yml"),
    GUI_TEMPLATE_COMMANDS("lang/en/gui/templates/template_commands_view.yml"),
    GUI_CODE_DURATION("lang/en/gui/codes/code_duration_view.yml"),
    GUI_TEMPLATE_DURATION("lang/en/gui/templates/template_duration_view.yml"),
    GUI_CODE_MESSAGES("lang/en/gui/codes/code_messages_view.yml"),
    GUI_TEMPLATE_MESSAGES("lang/en/gui/templates/template_messages_view.yml"),
    GUI_CODE_RESTRICTION("lang/en/gui/codes/code_restriction_view.yml"),
    GUI_CODE_TARGETS("lang/en/gui/codes/code_targets_view.yml"),
    GUI_TEMPLATE_SYNCHRONIZER("lang/en/gui/templates/template_syncronizor_view.yml"),
    GUI_COUPON_HISTORY("lang/en/gui/coupons/coupon_history_view.yml"),
    GUI_SOUNDS("lang/en/gui/sounds_view.yml")
}