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


package net.justlime.redeemcodex

import org.bukkit.plugin.java.JavaPlugin

object RedeemX {
    lateinit var plugin: JavaPlugin
    lateinit var gui: net.justlime.redeemcodex.service.RedeemGUIService
    lateinit var create: net.justlime.redeemcodex.service.RedeemCreateService
    lateinit var edit: net.justlime.redeemcodex.service.RedeemEditService
    lateinit var delete: net.justlime.redeemcodex.service.RedeemDeleteService
    lateinit var message: net.justlime.redeemcodex.dao.RedeemMessage
    lateinit var cache: net.justlime.redeemcodex.service.CacheService
    lateinit var coupon: net.justlime.redeemcodex.service.RedeemCouponService
    lateinit var notifier: net.justlime.redeemcodex.service.CouponNotifierService
    lateinit var redeemCodeDao: net.justlime.redeemcodex.dao.RedeemCodeDao
    lateinit var redeemTemplateDao: net.justlime.redeemcodex.dao.RedeemTemplateDao
    lateinit var redeemCouponDao: net.justlime.redeemcodex.dao.RedeemCouponDao
    lateinit var couponNotifierDao: net.justlime.redeemcodex.dao.CouponNotifierDao
    lateinit var redeemLogDao: net.justlime.redeemcodex.dao.RedeemLogDao
    lateinit var accountLinkDao: net.justlime.redeemcodex.dao.AccountLinkDao
    lateinit var notificationToggleDao: net.justlime.redeemcodex.dao.NotificationToggleDao
}