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

import api.justlime.redeemcodex.models.RedeemCode
import api.justlime.redeemcodex.models.RedeemTemplate
import api.justlime.redeemcodex.models.RedeemType
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender

/**
 * Service responsible for creating and generating RedeemCodes and Templates.
 * Handles database insertion, logging, and chat feedback.
 */
interface RedeemCreate {

    /**
     * Creates a single RedeemType (Code or Template).
     *
     * @param redeemType The object to create.
     * @param sender The command sender (defaults to Console) for logging/feedback.
     * @param onCreate Callback executed with `true` if creation was successful.
     */
    fun create(redeemType: RedeemType, sender: CommandSender = Bukkit.getConsoleSender(), onCreate: (success: Boolean) -> Unit = {})

    /**
     * Creates a batch of RedeemTypes.
     *
     * @param redeemTypes The list of objects to create.
     * @param sender The command sender for logging/feedback.
     * @param onCreate Callback executed with `true` if the batch operation was successful.
     */
    fun create(redeemTypes: List<RedeemType>, sender: CommandSender = Bukkit.getConsoleSender(), onCreate: (success: Boolean) -> Unit = {})

    /**
     * Creates a specific RedeemCode using a string identifier and a Template object.
     *
     * @param code The specific code string (e.g., "SUMMER2024").
     * @param redeemTemplate The template configuration to apply.
     */
    fun create(code: String, redeemTemplate: RedeemTemplate, sender: CommandSender = Bukkit.getConsoleSender(), onCreate: (success: Boolean) -> Unit = {})

    /**
     * Creates multiple specific RedeemCodes using a list of strings and a Template object.
     *
     * @param codes The list of code strings to create.
     * @param redeemTemplate The template configuration to apply.
     */
    fun create(codes: List<String>, redeemTemplate: RedeemTemplate, sender: CommandSender = Bukkit.getConsoleSender(), onCreate: (success: Boolean) -> Unit = {})

    /**
     * Creates a specific RedeemCode using a string identifier and a Template name.
     * The template will be looked up from the database/cache.
     *
     * @param code The specific code string.
     * @param template The name of the template.
     */
    fun create(code: String, template: String, sender: CommandSender = Bukkit.getConsoleSender(), onCreate: (success: Boolean) -> Unit = {})

    /**
     * Creates multiple specific RedeemCodes using a list of strings and a Template name.
     *
     * @param codes The list of code strings.
     * @param template The name of the template.
     */
    fun create(codes: List<String>, template: String, sender: CommandSender = Bukkit.getConsoleSender(), onCreate: (success: Boolean) -> Unit = {})

    /**
     * Generates and creates a **single random code** of a specific length.
     *
     * @param digit The length of the generated code.
     * @param redeemTemplate The template object to use.
     * @param onCreate Callback containing the generated code.
     */
    fun create(digit: Int, redeemTemplate: RedeemTemplate, sender: CommandSender = Bukkit.getConsoleSender(), onCreate: (code: RedeemCode?) -> Unit = {})

    /**
     * Generates and creates a **single random code** of a specific length using a template name.
     *
     * @param digit The length of the generated code.
     * @param template The name of the template.
     */
    fun create(digit: Int, template: String, sender: CommandSender = Bukkit.getConsoleSender(), onCreate: (code: RedeemCode?) -> Unit = {})

    fun create(digit: Int, redeemTemplate: RedeemTemplate, amount: Int, codes: List<String> = mutableListOf(), sender: CommandSender = Bukkit.getConsoleSender(), onCreate: (codes: List<RedeemCode>) -> Unit = {})

    fun create(digit: Int, template: String, amount: Int, codes: List<String> = mutableListOf(), sender: CommandSender = Bukkit.getConsoleSender(), onCreate: (codes: List<RedeemCode>) -> Unit = {})

    fun create(template: String, sender: CommandSender = Bukkit.getConsoleSender(), onCreate: (success: Boolean) -> Unit = {})

}