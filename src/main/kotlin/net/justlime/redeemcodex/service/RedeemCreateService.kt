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

package net.justlime.redeemcodex.service

import net.justlime.redeemcodex.adapter.RCXSender
import net.justlime.redeemcodex.models.core.RedeemCode
import net.justlime.redeemcodex.models.core.RedeemTemplate
import net.justlime.redeemcodex.models.core.RedeemType

/**
 * Service responsible for creating and generating RedeemCodes and Templates.
 * Handles database insertion, logging, and chat feedback.
 */
interface RedeemCreateService {

    /**
     * Creates a single RedeemType (Code or Template).
     *
     * @param redeemType The object to create.
     * @param sender The command sender for logging/feedback.
     * @param onCreate Called with the created [RedeemType] or null if creation failed.
     */
    fun create(redeemType: RedeemType, sender: RCXSender?, onCreate: (redeemType: RedeemType?) -> Unit)

    /**
     * Creates a batch of RedeemTypes.
     *
     * @param redeemTypes The list of objects to create.
     * @param sender The command sender for logging/feedback.
     * @param onCreate Called with a list of successfully created [RedeemType]s.
     */
    fun create(redeemTypes: List<RedeemType>, sender: RCXSender?, onCreate: (redeemTypes: List<RedeemType>) -> Unit)

    /**
     * Creates a specific RedeemCode using a string identifier and a Template object.
     *
     * @param code The specific code string (e.g., "SUMMER2024").
     * @param redeemTemplate The template configuration to apply.
     * @param onCreate Called with the created [RedeemCode] or null if creation failed.
     */
    fun create(code: String, redeemTemplate: RedeemTemplate, sender: RCXSender?, onCreate: (redeemCode: RedeemCode?) -> Unit)

    /**
     * Creates multiple specific RedeemCodes using a list of strings and a Template object.
     *
     * @param codes The list of code strings to create.
     * @param redeemTemplate The template configuration to apply.
     * @param onCreate Called with a list of successfully created [RedeemCode]s.
     */
    fun create(codes: List<String>, redeemTemplate: RedeemTemplate, sender: RCXSender?, onCreate: (redeemCodes: List<RedeemCode>) -> Unit)

    /**
     * Creates a specific RedeemCode using a string identifier and a Template name.
     * The template will be looked up from the database/cache.
     *
     * @param code The specific code string.
     * @param template The name of the template.
     * @param onCreate Called with the created [RedeemCode] or null if creation failed.
     */
    fun create(code: String, template: String, sender: RCXSender?, onCreate: (redeemCode: RedeemCode?) -> Unit)

    /**
     * Creates multiple specific RedeemCodes using a list of strings and a Template name.
     *
     * @param codes The list of code strings.
     * @param template The name of the template.
     * @param onCreate Called with a list of successfully created [RedeemCode]s.
     */
    fun create(codes: List<String>, template: String, sender: RCXSender?, onCreate: (redeemCodes: List<RedeemCode>) -> Unit = {})

    /**
     * Generates and creates a **single random code** of a specific length.
     *
     * @param digit The length of the generated code.
     * @param redeemTemplate The template object to use.
     * @param onCreate Called with the generated code, or null if it failed
     */
    fun create(digit: Int, redeemTemplate: RedeemTemplate, sender: RCXSender?, onCreate: (redeemCode: RedeemCode?) -> Unit)

    /**
     * Generates and creates a **single random code** of a specific length using a template name.
     *
     * @param digit The length of the generated code.
     * @param template The name of the template.
     * @param onCreate Called with the generated code, or null if it failed
     */
    fun create(digit: Int, template: String, sender: RCXSender?, onCreate: (redeemCode: RedeemCode?) -> Unit)

    /**
     * Generates and creates **multiple random codes** of a specific length.
     *
     * @param digit The length of the generated codes.
     * @param redeemTemplate The template object to use.
     * @param amount The number of codes to generate.
     * @param codes An optional list to add the generated codes to.
     * @param onCreate Called with the list of generated codes.
     */
    fun create(digit: Int, redeemTemplate: RedeemTemplate, amount: Int, codes: List<String> = mutableListOf(), sender: RCXSender?, onCreate: (redeemCodes: List<RedeemCode>) -> Unit)

    /**
     * Generates and creates **multiple random codes** of a specific length using a template name.
     *
     * @param digit The length of the generated codes.
     * @param template The name of the template.
     * @param amount The number of codes to generate.
     * @param codes An optional list to add the generated codes to.
     * @param onCreate Called with the list of generated codes.
     */
    fun create(digit: Int, template: String, amount: Int, codes: List<String> = mutableListOf(), sender: RCXSender?, onCreate: (redeemCodes: List<RedeemCode>) -> Unit = {})

    /**
     * Creates a RedeemTemplate from a given template name.
     *
     * @param template The name of the template to create.
     * @param sender The command sender for logging/feedback.
     * @param onCreate Called with the created [RedeemTemplate] or null if creation failed.
     */
    fun create(template: String, sender: RCXSender?, onCreate: (redeemTemplate: RedeemTemplate?) -> Unit)

}