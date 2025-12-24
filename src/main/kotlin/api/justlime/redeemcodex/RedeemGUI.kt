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
import api.justlime.redeemcodex.models.core.RedeemCode
import api.justlime.redeemcodex.models.core.RedeemType
import org.bukkit.entity.Player
import java.util.*

/**
 *    Interface for managing RedeemCodeX plugin's user interfaces.
 * This interface provides methods to open various GUI menus for managing redeem codes, templates, and coupons.
 **/
interface RedeemGUI {

    /**
     * Opens the main selection menu (Redeem Code, Template, Voucher, etc.).
     */
    fun openMainMenu(viewer: Player)

    /**
     * Opens the paginated list of codes or templates for administrative viewing.
     * @param viewer The player viewing the list.
     * @param redeemCategory The type of list to open (Code or Template).
     * @param pageId The page number to start on (defaults to 1).
     */
    fun openListPage(viewer: Player, redeemCategory: RedeemCategory, pageId: Int = 1)

    /**
     * Opens the main editing menu for a specific RedeemType.
     */
    fun openEditorGUI(viewer: Player, redeemType: RedeemType, pageId: Int)

    /**
     * Opens the restrictions/limits editor menu.
     */
    fun openRestrictionGUI(viewer: Player, redeemType: RedeemType, pageId: Int = 1)

    /**
     * Opens the duration/expiry editor menu.
     */
    fun openDurationGUI(viewer: Player, redeemType: RedeemType, pageId: Int = 1)

    /**
     * Opens the command list editor menu.
     */
    fun openCommandGUI(viewer: Player, redeemType: RedeemType, pageId: Int = 1)

    /**
     * Opens the message editor menu (Chat, Actionbar, Title).
     */
    fun openMessageGUI(viewer: Player, redeemType: RedeemType, pageId: Int = 1)

    /**
     * Opens the target player editor menu for a RedeemCode.
     */
    fun openTargetGUI(viewer: Player, redeemCode: RedeemCode, pageId: Int)

    /**
     * Opens the rewards editor menu.
     */
    fun openRewardGUI(viewer: Player, redeemType: RedeemType, pageId: Int = 1)

    /**
     * Opens the synchronizer property manager page (for Templates).
     */
    fun openSynchronizerGUI(viewer: Player, redeemType: RedeemType, pageId: Int)

    /**
     * Opens the menu showing coupons available for the player.
     */
    fun openAvailableCouponGUI(viewer: Player)

    fun openOtherAvailableCouponGUI(viewer: Player, targetUUID: UUID)

    /**
     * Opens the menu showing the player's coupon redemption history.
     */
    fun openCouponHistoryGUI(viewer: Player)

    fun openOtherCouponHistoryGUI(viewer: Player, targetUUID: UUID)

}