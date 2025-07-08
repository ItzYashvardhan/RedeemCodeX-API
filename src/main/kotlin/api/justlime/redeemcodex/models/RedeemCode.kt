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



package api.justlime.redeemcodex.models


import org.bukkit.inventory.ItemStack
import java.sql.Timestamp

data class RedeemCode(
    var code: String, var enabledStatus: Boolean,

    var template: String, //Blank for disabled
    var sync: Boolean,

    var duration: String, //0s for disabled
    var cooldown: String, //0s for disabled

    var permission: String, //Blank for disabled
    var pin: Int, //0 for disabled

    var redemption: Int, //0 for infinite Redemption limit
    var playerLimit: Int, //0 for infinite player limit

    var usedBy: MutableMap<String, Int>,

    var validFrom: Timestamp, var lastRedeemed: MutableMap<String, Timestamp>,

    var target: MutableList<String>, //Blank for disabled
    var commands: MutableList<String>, //Empty list for disabled

    var rewards: MutableList<ItemStack> = mutableListOf(),
    var messages: MessageState,
    var sound: SoundState,

    var playerIp: MutableMap<String, Int>,//Key - Ip, Value - PlayerName
    var condition: String,
    var modified: Timestamp
)