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

import api.justlime.redeemcodex.enums.RedeemCategory
import api.justlime.redeemcodex.models.RedeemCode
import api.justlime.redeemcodex.models.RedeemTemplate
import api.justlime.redeemcodex.models.RedeemType
import org.bukkit.command.CommandSender
import java.util.*

/**
 * Interface for interacting with the RedeemCodeX plugin's core services.
 * This provides methods for managing redeem codes, templates, and coupons,
 * including creation, retrieval, updating, and deletion, as well as
 * specific property modifications.
 */
interface RedeemService {


    val create: RedeemCreate
    val modify: RedeemModify
    val delete: RedeemDelete


    // --- GET/FETCH OPERATIONS (All Async with Callback) ---

    fun get(redeemCategory: RedeemCategory, name: String, redeemType: (RedeemType?) -> Unit)

    fun get(redeemCategory: RedeemCategory, redeemType: (List<RedeemType>) -> Unit)

    fun get(redeemCategory: RedeemCategory, name: List<String>, redeemType: (List<RedeemType>) -> Unit)

    fun get(template: String, lockedStatus: Boolean?, redeemType: (List<RedeemType>) -> Unit)

    fun getCodes(redeemCodes: (List<String>) -> Unit)

    fun getExpiredCodes(sender: CommandSender, redeemCode: (List<String>) -> Unit)

    fun isTemplateExist(template: String): Boolean

    fun update(sender: CommandSender, redeemType: RedeemType, onUpdate: (success: Boolean) -> Unit)

    fun update(sender: CommandSender, redeemTypes: List<RedeemType>, onUpdate: (success: Boolean) -> Unit)


    // --- DELETE OPERATIONS ---

    fun delete(sender: CommandSender, redeemCategory: RedeemCategory, name: String, onDelete: (success: Boolean) -> Unit)

    fun delete(sender: CommandSender, redeemCategory: RedeemCategory, name: List<String>, onDelete: (success: Boolean) -> Unit)

    fun deleteCodesByTemplate(sender: CommandSender, template: String, onDelete: (success: Boolean) -> Unit)


    // --- TOGGLE / SET OPERATIONS ---

    fun toggleEnabledStatus(sender: CommandSender, redeemType: RedeemType, onUpdate: (success: Boolean) -> Unit)

    fun toggleRequiredPermission(sender: CommandSender, redeemTemplate: RedeemTemplate, onUpdate: (success: Boolean) -> Unit)

    fun setTemplate(sender: CommandSender, redeemCode: RedeemCode, template: String, onUpdate: (success: Boolean) -> Unit)

    fun toggleSyncStatus(sender: CommandSender, redeemCode: RedeemCode, onUpdate: (success: Boolean) -> Unit)

    fun toggleTemplateSyncStatus(sender: CommandSender, redeemTemplate: RedeemTemplate, property: String, onUpdate: (success: Boolean) -> Unit)

    fun setPermission(sender: CommandSender, redeemType: RedeemType, permission: String?, onUpdate: (success: Boolean) -> Unit)

    fun setTemplatePermission(sender: CommandSender, redeemCode: RedeemCode, onUpdate: (success: Boolean) -> Unit)

    fun setPin(sender: CommandSender, redeemType: RedeemType, pin: String?, onUpdate: (success: Boolean) -> Unit)

    fun setCooldown(sender: CommandSender, redeemType: RedeemType, cooldown: String?, onUpdate: (success: Boolean) -> Unit)

    fun setRedemption(sender: CommandSender, redeemType: RedeemType, redemption: Int?, onUpdate: (success: Boolean) -> Unit)

    fun setPlayerLimit(sender: CommandSender, redeemType: RedeemType, playerLimit: Int?, onUpdate: (success: Boolean) -> Unit)

    fun setExpiry(sender: CommandSender, redeemType: RedeemType, duration: String, onUpdate: (success: Boolean) -> Unit)

    fun setCondition(sender: CommandSender, redeemType: RedeemType, condition: String?, onUpdate: (success: Boolean) -> Unit)

    fun addCommand(sender: CommandSender, redeemType: RedeemType, command: String, onUpdate: (success: Boolean) -> Unit)

    fun setCommand(sender: CommandSender, redeemType: RedeemType, id: Int, command: String, onUpdate: (success: Boolean) -> Unit)

    fun removeCommand(sender: CommandSender, redeemType: RedeemType, id: Int, onUpdate: (success: Boolean) -> Unit)

    fun addTarget(sender: CommandSender, redeemCode: RedeemCode, target: List<UUID>, onUpdate: (success: Boolean) -> Unit)

    fun setTarget(sender: CommandSender, redeemCode: RedeemCode, target: List<UUID>, onUpdate: (success: Boolean) -> Unit)

    fun removeTarget(sender: CommandSender, redeemCode: RedeemCode, target: List<UUID>, onUpdate: (success: Boolean) -> Unit)

    fun addMessage(sender: CommandSender, redeemType: RedeemType, message: String, onUpdate: (success: Boolean) -> Unit)

    fun setMessage(sender: CommandSender, redeemType: RedeemType, id: Int, message: String, onUpdate: (success: Boolean) -> Unit)

    fun removeMessage(sender: CommandSender, redeemType: RedeemType, id: Int, onUpdate: (success: Boolean) -> Unit)

    fun setActionBar(sender: CommandSender, redeemType: RedeemType, message: String?, onUpdate: (success: Boolean) -> Unit)

    fun setTitle(sender: CommandSender, redeemType: RedeemType, title: String?, fadeIn: Long, stay: Long, fadeOut: Long, onUpdate: (success: Boolean) -> Unit)

    fun setSubtitle(sender: CommandSender, redeemType: RedeemType, subtitle: String?, onUpdate: (success: Boolean) -> Unit)

    fun setSound(sender: CommandSender, redeemType: RedeemType, sound: String?, volume: Float, pitch: Float, onUpdate: (success: Boolean) -> Unit)

    fun adjustDuration(sender: CommandSender, redeemType: RedeemType, existingDuration: String, duration: String, isAdding: Boolean, onUpdate: (success: Boolean) -> Unit)
}