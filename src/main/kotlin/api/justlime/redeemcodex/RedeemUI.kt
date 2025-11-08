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
import api.justlime.redeemcodex.models.RedeemType

/**
 *    Interface for managing RedeemCodeX plugin's user interfaces.
 * This interface provides methods to open various GUI menus for managing redeem codes, templates, and coupons.
 *  */
interface RedeemUI {

    /**
     * Opens the Selection Menu.
     * **/
    fun openMainMenu()

    /**
     * Open a List gui for Given Category*/
    fun openListPage(redeemCategory: RedeemCategory, pageId: Int)

    /**
     * Open an editor GUI for Given RedeemType
     * @param redeemType RedeemType to edit
     * @param pageId Current Page Id
     * */
    fun openEditorMenu(redeemType: RedeemType, pageId: Int)

    /**
     * Opens a menu to manage restrictions for a redeem type.
     * @param redeemType The redeem type to edit.
     * @param pageId The current page ID.
     */
    fun openRestrictionMenu(redeemType: RedeemType, pageId: Int)

    /**
     * Opens a menu to set the duration for a redeem type.
     * @param redeemType The redeem type to edit.
     * @param pageId The current page ID.
     */
    fun openDurationMenu(redeemType: RedeemType, pageId: Int)

    /**
     * Opens an editor for commands associated with a redeem type.
     * @param redeemType The redeem type to edit.
     * @param pageId The current page ID.
     */
    fun openCommandEditor(redeemType: RedeemType, pageId: Int)

    /**
     * Opens a menu to configure messages for a redeem type.
     * @param redeemType The redeem type to edit.
     * @param pageId The current page ID.
     */
    fun openMessageMenu(redeemType: RedeemType, pageId: Int)

    /**
     * Opens a menu to define the target for a redeem code.
     * @param redeemCode The redeem code to edit.
     * @param pageId The current page ID.
     */
    fun openTargetMenu(redeemCode: RedeemCode, pageId: Int)

    /**
     * Opens an editor for rewards of a redeem type.
     * @param redeemType The redeem type to edit.
     * @param pageId The current page ID.
     */
    fun openRewardEditor(redeemType: RedeemType, pageId: Int)

    /**
     * Opens a manager for synchronizes related to a redeem type.
     * @param redeemType The redeem type to edit.
     * @param pageId The current page ID.
     */
    fun openSynchronizerManager(redeemType: RedeemType, pageId: Int)

    /**
     * Opens a menu showing available coupons.
     */
    fun openAvailableCouponMenu()

    /**
     * Opens a menu showing the history of used coupons.
     */
    fun openHistoryCouponMenu()

}