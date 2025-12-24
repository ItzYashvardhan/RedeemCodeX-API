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

package api.justlime.redeemcodex.service

import api.justlime.redeemcodex.models.core.RedeemCode
import org.bukkit.OfflinePlayer
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.*

interface RedeemCoupon {

    /**
     * Gives a coupon to a player.
     *
     * @param uuid The UUID of the player.
     * @param code The code of the coupon to give.
     * @param onComplete Callback indicating if the operation was successful.
     */
    fun giveCoupon(sender: CommandSender, uuid: UUID, code: String, onComplete: (success: Boolean) -> Unit = {})

    /**
     * Gives a specified amount of randomly generated coupons from a template to a player.
     *
     * @param uuid The UUID of the player.
     * @param templateName The name of the template to generate codes from.
     * @param digit The length of the codes to generate.
     * @param amount The number of codes to generate and give.
     * @param secured If true, the generated codes will be secured to the player, meaning only they can redeem them.
     * @param onComplete Callback containing a list of the generated RedeemCode objects.
     */
    fun giveRandomCoupons(sender: CommandSender, uuid: UUID, templateName: String, digit: Int, amount: Int, secured: Boolean, onComplete: (codes: List<RedeemCode>) -> Unit = {})

    /**
     * Gives a coupon to all online players.
     *
     * @param code The code of the coupon to give.
     * @param onComplete Callback indicating if the operation was successful.
     */
    fun giveCouponToAllOnline(sender: CommandSender, code: String, onComplete: (success: Boolean) -> Unit = {})

    /**
     * Gives a coupon to all players (online and offline).
     *
     * @param code The code of the coupon to give.
     * @param onComplete Callback indicating if the operation was successful.
     */
    fun giveCouponToAll(sender: CommandSender, code: String, onComplete: (success: Boolean) -> Unit = {})

    /**
     * Gives a randomly generated coupon from a template to all online players.
     *
     * @param templateName The name of the template to generate codes from.
     * @param digit The length of the codes to generate.
     * @param secured If true, the generated codes will be secured to the player, meaning only they can redeem them.
     * @param onComplete Callback containing a map of player UUIDs to the generated RedeemCode objects.
     */
    fun giveRandomCouponToAllOnline(sender: CommandSender, templateName: String, digit: Int, secured: Boolean, onComplete: (playerCodes: Map<String, RedeemCode>) -> Unit = {})

    /**
     * Gives a randomly generated coupon from a template to all players (online and offline).
     *
     * @param templateName The name of the template to generate codes from.
     * @param digit The length of the codes to generate.
     * @param secured If true, the generated codes will be secured to the player, meaning only they can redeem them.
     * @param onComplete Callback containing a map of player UUIDs to the generated RedeemCode objects.
     */
    fun giveRandomCouponToAll(sender: CommandSender, templateName: String, digit: Int, secured: Boolean, onComplete: (playerCodes: Map<String, RedeemCode>) -> Unit = {})

    /**
     * Gifts a coupon from one player to another.
     *
     * @param sender The command sender initiating the gift.
     * @param fromPlayer The player gifting the coupon.
     * @param toPlayer The player receiving the coupon.
     * @param code The code of the coupon to gift.
     * @param onComplete Callback indicating if the operation was successful.
     */
    fun gift(sender: Player, toPlayer: OfflinePlayer, code: String, onComplete: (success: Boolean) -> Unit = {})


    /**
     * Takes a coupon from a player.
     *
     * @param uuid The UUID of the player.
     * @param code The code of the coupon to take.
     * @param onComplete Callback indicating if the operation was successful.
     */
    fun takeCoupon(sender: CommandSender, uuid: UUID, code: String, onComplete: (success: Boolean) -> Unit = {})

    /**
     * Takes all coupons associated with a specific template from a player.
     *
     * @param uuid The UUID of the player.
     * @param templateName The name of the template.
     * @param onComplete Callback indicating if the operation was successful.
     */
    fun takeAllCouponsByTemplate(sender: CommandSender, uuid: UUID, templateName: String, onComplete: (success: Boolean) -> Unit = {})

    /**
     * Takes a coupon from all online players.
     *
     * @param code The code of the coupon to take.
     * @param onComplete Callback indicating if the operation was successful.
     */
    fun takeCouponFromAllOnline(sender: CommandSender, code: String, onComplete: (success: Boolean) -> Unit = {})

    /**
     * Takes a coupon from all players (online and offline).
     *
     * @param code The code of the coupon to take.
     * @param onComplete Callback indicating if the operation was successful.
     */
    fun takeCouponFromAll(sender: CommandSender, code: String, onComplete: (success: Boolean) -> Unit = {})

    /**
     * Takes all coupons associated with a specific template from all online players.
     *
     * @param templateName The name of the template.
     * @param onComplete Callback indicating if the operation was successful.
     */
    fun takeAllCouponsByTemplateFromAllOnline(sender: CommandSender, templateName: String, onComplete: (success: Boolean) -> Unit = {})

    /**
     * Takes all coupons associated with a specific template from all players (online and offline).
     *
     * @param templateName The name of the template.
     * @param onComplete Callback indicating if the operation was successful.
     */
    fun takeAllCouponsByTemplateFromAll(sender: CommandSender, templateName: String, onComplete: (success: Boolean) -> Unit = {})

}