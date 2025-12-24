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

import api.justlime.redeemcodex.dao.CouponNotifierDao
import api.justlime.redeemcodex.dao.RedeemCodeDao
import api.justlime.redeemcodex.dao.RedeemCouponDao
import api.justlime.redeemcodex.dao.RedeemLogDao
import api.justlime.redeemcodex.dao.RedeemMessage
import api.justlime.redeemcodex.dao.RedeemTemplateDao
import api.justlime.redeemcodex.service.ICouponNotifier
import api.justlime.redeemcodex.service.RedeemCoupon
import api.justlime.redeemcodex.service.RedeemCreate
import api.justlime.redeemcodex.service.RedeemDelete
import api.justlime.redeemcodex.service.RedeemModify
import api.justlime.redeemcodex.utilities.PlayerService

object RedeemX {
    lateinit var create: RedeemCreate
    lateinit var modify: RedeemModify
    lateinit var delete: RedeemDelete
    lateinit var message: RedeemMessage
    lateinit var playerService: PlayerService
    lateinit var redeemLogDao: RedeemLogDao
    lateinit var redeemCodeDao: RedeemCodeDao
    lateinit var redeemTemplateDao: RedeemTemplateDao
    lateinit var gui: RedeemGUI

    lateinit var coupon: RedeemCoupon
    lateinit var notifier: ICouponNotifier
    lateinit var redeemCouponDao: RedeemCouponDao
    lateinit var couponNotifierDao: CouponNotifierDao

}