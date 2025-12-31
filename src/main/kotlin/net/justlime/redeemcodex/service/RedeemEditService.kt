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
import java.util.*

interface RedeemEditService {
    fun update(sender: RCXSender, redeemType: RedeemType, onUpdate: (success: Boolean) -> Unit)

    fun update(sender: RCXSender, redeemTypes: List<RedeemType>, onUpdate: (success: Boolean) -> Unit)

    // --- TOGGLE / SET OPERATIONS ---

    fun toggleEnabledStatus(sender: RCXSender, redeemType: RedeemType, onUpdate: (success: Boolean) -> Unit)

    fun toggleRequiredPermission(sender: RCXSender, redeemTemplate: RedeemTemplate, onUpdate: (success: Boolean) -> Unit)

    fun setTemplate(sender: RCXSender, redeemCode: RedeemCode, template: String, onUpdate: (success: Boolean) -> Unit)

    fun toggleSyncStatus(sender: RCXSender, redeemCode: RedeemCode, onUpdate: (success: Boolean) -> Unit)

    fun toggleTemplateSyncStatus(sender: RCXSender, redeemTemplate: RedeemTemplate, property: String, onUpdate: (success: Boolean) -> Unit)

    fun setPermission(sender: RCXSender, redeemType: RedeemType, permission: String?, onUpdate: (success: Boolean) -> Unit)

    fun setTemplatePermission(sender: RCXSender, redeemCode: RedeemCode, onUpdate: (success: Boolean) -> Unit)

    fun setPin(sender: RCXSender, redeemType: RedeemType, pin: String?, onUpdate: (success: Boolean) -> Unit)

    fun setCooldown(sender: RCXSender, redeemType: RedeemType, cooldown: String?, onUpdate: (success: Boolean) -> Unit)

    fun setRedemption(sender: RCXSender, redeemType: RedeemType, redemption: Int?, onUpdate: (success: Boolean) -> Unit)

    fun setPlayerLimit(sender: RCXSender, redeemType: RedeemType, playerLimit: Int?, onUpdate: (success: Boolean) -> Unit)


    fun setCondition(sender: RCXSender, redeemType: RedeemType, condition: String?, onUpdate: (success: Boolean) -> Unit)

    fun addCommand(sender: RCXSender, redeemType: RedeemType, command: String, onUpdate: (success: Boolean) -> Unit)

    fun setCommand(sender: RCXSender, redeemType: RedeemType, id: Int, command: String, onUpdate: (success: Boolean) -> Unit)

    fun removeCommand(sender: RCXSender, redeemType: RedeemType, id: Int, onUpdate: (success: Boolean) -> Unit)

    fun addTarget(sender: RCXSender, redeemCode: RedeemCode, target: List<UUID>, onUpdate: (success: Boolean) -> Unit)

    fun setTarget(sender: RCXSender, redeemCode: RedeemCode, target: List<UUID>, onUpdate: (success: Boolean) -> Unit)

    fun removeTarget(sender: RCXSender, redeemCode: RedeemCode, target: List<UUID>, onUpdate: (success: Boolean) -> Unit)

    fun addMessage(sender: RCXSender, redeemType: RedeemType, message: String, onUpdate: (success: Boolean) -> Unit)

    fun setMessage(sender: RCXSender, redeemType: RedeemType, id: Int, message: String, onUpdate: (success: Boolean) -> Unit)

    fun removeMessage(sender: RCXSender, redeemType: RedeemType, id: Int, onUpdate: (success: Boolean) -> Unit)

    fun setActionBar(sender: RCXSender, redeemType: RedeemType, message: String?, onUpdate: (success: Boolean) -> Unit)

    fun setTitle(sender: RCXSender, redeemType: RedeemType, title: String?, fadeIn: Long, stay: Long, fadeOut: Long, onUpdate: (success: Boolean) -> Unit)

    fun setSubtitle(sender: RCXSender, redeemType: RedeemType, subtitle: String?, onUpdate: (success: Boolean) -> Unit)

    fun setSound(sender: RCXSender, redeemType: RedeemType, sound: String?, volume: Float, pitch: Float, onUpdate: (success: Boolean) -> Unit)

    fun adjustDuration(sender: RCXSender, redeemType: RedeemType, existingDuration: String, duration: String, isAdding: Boolean, onUpdate: (success: Boolean) -> Unit)

}