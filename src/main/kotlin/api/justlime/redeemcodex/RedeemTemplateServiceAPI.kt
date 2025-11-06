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
 *
 *
 */


package api.justlime.redeemcodex

import api.justlime.redeemcodex.models.RCXPlaceHolder
import api.justlime.redeemcodex.models.RedeemCode
import api.justlime.redeemcodex.models.RedeemTemplate

/**
 * RedeemTemplateServiceAPI defines operations for managing redeem code templates.
 * Templates typically define rules such as generation behavior
 * for redeem codes.
 */
@Deprecated("In favour of RedeemService")
interface RedeemTemplateServiceAPI {

    /**
     * Checks whether a template with the specified name exists.
     *
     * @param template The name or key of the template.
     * @return `true` if the template exists, `false` otherwise.
     */
    fun isTemplateExist(template: String): Boolean

    /**
     * Retrieves the [RedeemTemplate] object for the given name.
     *
     * @param template The name or key of the template.
     * @return The corresponding [RedeemTemplate], or `null` if not found.
     */
    fun getTemplate(template: String): RedeemTemplate?

    /**
     * Returns a list of all available template names.
     *
     * @return A list of template identifiers.
     */
    fun getTemplates(): List<String>

    /**
     * Returns a list of all available [RedeemCode].
     *
     * @return A list of [RedeemCode] objects.
     */
    fun getTemplateCodes(template: RedeemTemplate): List<RedeemCode>

    /**
     * Generates a new [RedeemTemplate] with the given name.
     *
     *
     * @param template The name or key for the new template.
     * @return The generated [RedeemTemplate] object.
     * @throws IllegalStateException if a template with the same name already exists.
     */
    fun generateTemplate(template: String): RedeemTemplate

    /**
     * Deletes a template by its name.
     *
     * @param template The name or key of the template to delete.
     * @return `true` if the template was successfully deleted, `false` otherwise.
     */
    fun deleteTemplate(template: String): Boolean

    /**
     * Synchronizes all [api.justlime.redeemcodex.models.RedeemCode] that were linked using the provided [RedeemTemplate].
     *
     * This method re-applies the logic, rules, or behaviour defined in the given template
     * to all associated redeem codes—ensuring consistency after a template update.
     *
     * ⚠️ **Important:**
     * This only affects codes that are explicitly linked from the specified template.
     * Existing codes not linked with it will remain unchanged.
     *
     * @param redeemTemplate The [RedeemTemplate] used to re-synchronize matching codes.
     * @return `true` if the synchronization was successful, `false` otherwise.
     */
    fun syncCodes(redeemTemplate: RedeemTemplate): Boolean


    /**
     * Inserts a new template or updates an existing one.
     *
     * **Important!!**
     * Use this method after generating or modifying a [RedeemTemplate] to ensure changes are saved.
     *
     * @param template The [RedeemTemplate] to insert or update.
     * @return `true` if the operation succeeded, `false` otherwise.
     */
    fun upsertTemplate(template: RedeemTemplate): Boolean


}
