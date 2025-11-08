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

package api.justlime.redeemcodex

import api.justlime.redeemcodex.enums.RedeemCategory
import api.justlime.redeemcodex.models.RedeemCode
import api.justlime.redeemcodex.models.RedeemTemplate
import api.justlime.redeemcodex.models.RedeemType
import java.util.*

interface RedeemService {

    //-----ALL Get Method Operation-----//

    /**Get a certain code or template from database or config file using code name or template name**/
    fun get(redeemCategory: RedeemCategory, name: String): RedeemType?

    /**Get all List of RedeemType from database or config file*/
    fun get(redeemCategory: RedeemCategory): List<RedeemType>

    /**Get list of code or template from database or config file using list of code name or template name**/
    fun get(redeemCategory: RedeemCategory, names: List<String>): List<RedeemType>

    /**Get list of code from database by their template name.
     * @param template Give template name here
     * @param lockedStatus Weather to get only sync code or vice versa use null to get all codes which inherit template*/
    fun get(template: String, lockedStatus: Boolean? = null): List<RedeemCode>

    /**Get all redeemable codes (plain text) from database*/
    fun getCodes(): Set<String>

    /**Get all expired redeem codes from database*/
    fun getExpiredCodes(): List<RedeemCode>

    //-----Create/Delete Method Operation-----//

    fun create(redeemType: RedeemType, onCreate: (success: Boolean) -> Unit = {})
    fun create(redeemTypes: List<RedeemType>, onCreate: (success: Boolean) -> Unit = {})

    /**Note if code not found it will try to generate new code with defined properties*/
    fun update(redeemType: RedeemType, onUpdate: (success: Boolean) -> Unit = {})

    /**Note if code not found it will try to generate new code with defined properties*/
    fun update(redeemTypes: List<RedeemType>, onUpdate: (success: Boolean) -> Unit = {})

    /**Note: When deleting template its codes will not be affected by this operation!*/
    fun delete(redeemCategory: RedeemCategory, name: String, onDelete: (success: Boolean) -> Unit = {})

    /**Note: When deleting template its codes will not be affected by this operation!*/
    fun delete(redeemCategory: RedeemCategory, names: List<String>, onDelete: (success: Boolean) -> Unit = {})

    /**Note: Template will not be affected by this operation!*/
    fun deleteCodesByTemplate(template: String, onDelete: (success: Boolean) -> Unit)

    //-----Modification Operation-----//

    //No need for update or sending a feedback message!*/
    fun toggleEnabledStatus(redeemType: RedeemType, onUpdate: (success: Boolean) -> Unit = {})

    /**Template Operations*/
    fun setTemplate(redeemCode: RedeemCode, template: String, onUpdate: (success: Boolean) -> Unit = {})
    fun toggleSyncStatus(redeemCode: RedeemCode, onUpdate: (success: Boolean) -> Unit = {})
    fun toggleTemplateSyncStatus(redeemTemplate: RedeemTemplate, property: String, onUpdate: (success: Boolean) -> Unit = {})

    /**Set Permissions*/
    fun setPermission(redeemType: RedeemType, permission: String?, onUpdate: (success: Boolean) -> Unit = {})
    fun setTemplatePermission(redeemCode: RedeemCode, onUpdate: (success: Boolean) -> Unit = {})
    fun toggleRequiredPermission(redeemTemplate: RedeemTemplate, onUpdate: (success: Boolean) -> Unit = {})

    /**Set Restrictions*/
    fun setPin(redeemType: RedeemType, pin: String?, onUpdate: (success: Boolean) -> Unit = {})
    fun setCooldown(redeemType: RedeemType, cooldown: String?, onUpdate: (success: Boolean) -> Unit = {})
    fun setRedemption(redeemType: RedeemType, redemption: Int?, onUpdate: (success: Boolean) -> Unit = {})
    fun setPlayerLimit(redeemType: RedeemType, playerLimit: Int?, onUpdate: (success: Boolean) -> Unit = {})
    fun setExpiry(redeemType: RedeemType, duration: String, onUpdate: (success: Boolean) -> Unit = {})
    fun setCondition(redeemType: RedeemType, condition: String?, onUpdate: (success: Boolean) -> Unit = {})

    /**Manage Commands*/
    fun addCommand(redeemType: RedeemType, command: String, onUpdate: (success: Boolean) -> Unit = {})
    fun setCommand(redeemType: RedeemType, id: Int, command: String, onUpdate: (success: Boolean) -> Unit)
    fun removeCommand(redeemType: RedeemType, id: Int, onUpdate: (success: Boolean) -> Unit = {})

    /**Manage Targets*/
    fun addTarget(redeemCode: RedeemCode, target: List<UUID>, onUpdate: (success: Boolean) -> Unit = {})
    fun setTarget(redeemCode: RedeemCode, target: List<UUID>, onUpdate: (success: Boolean) -> Unit = {})
    fun removeTarget(redeemCode: RedeemCode, target: List<UUID>, onUpdate: (success: Boolean) -> Unit = {})

    /**Edit Messages*/
    fun addMessage(redeemType: RedeemType, message: String, onUpdate: (success: Boolean) -> Unit = {})
    fun setMessage(redeemType: RedeemType, id: Int, message: String, onUpdate: (success: Boolean) -> Unit = {})
    fun removeMessage(redeemType: RedeemType, id: Int, onUpdate: (success: Boolean) -> Unit = {})
    fun setActionBar(redeemType: RedeemType, message: String?, onUpdate: (success: Boolean) -> Unit = {})
    fun setTitle(redeemType: RedeemType, title: String?, fadeIn: Long = 20, stay: Long = 70, fadeOut: Long = 20, onUpdate: (success: Boolean) -> Unit = {})
    fun setSubtitle(redeemType: RedeemType, subtitle: String?, onUpdate: (success: Boolean) -> Unit = {})
    fun setSound(redeemType: RedeemType, sound: String?, volume: Float = 1.0f, pitch: Float = 1.0f, onUpdate: (success: Boolean) -> Unit = {})

    /**Expiry Task Method*/
    fun adjustDuration(redeemType: RedeemType, existingDuration: String, duration: String, isAdding: Boolean, onUpdate: (success: Boolean) -> Unit)
}