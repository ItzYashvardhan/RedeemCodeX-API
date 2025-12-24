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

package api.justlime.redeemcodex.utilities

import api.justlime.redeemcodex.models.core.RedeemCode
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*
import java.util.concurrent.TimeUnit

object JTimeUtils {

    val currentTimeMillis: Timestamp get() = Timestamp.from(Instant.now())

    /**
     * Calculates the expiry date and time by adding a duration string to a start time.
     *
     * @param startTimeMillis The starting time in milliseconds since the epoch.
     * @param durationString A string representing the duration (e.g., "10s", "5m", "2h", "3d").
     * @return A human-readable string of the expiry date in "yyyy-MM-dd HH:mm:ss" format,
     * or an error message if the duration string is invalid.
     */
    fun calculateExpiry(startTimeMillis: Long, durationString: String): String {
        val durationMillis = parseDurationStringToMillis(durationString)
        if (durationMillis < 0) {
            return "Invalid duration format. Use 's' for seconds, 'm' for minutes, 'h' for hours, 'd' for days."
        }

        val expiryTimeMillis = startTimeMillis + durationMillis
        val expiryDate = Date(expiryTimeMillis)
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss z")
        return format.format(expiryDate)
    }

    /**
     * Calculates the remaining time between a future expiry time and the current time.
     *
     * @param expiryTimeMillis The expiry time in milliseconds since the epoch.
     * @param currentTimeMillis The current time in milliseconds to compare against. Defaults to System.currentTimeMillis().
     * @return A human-readable string representing the remaining duration (e.g., "2 days, 5 hours, 30 minutes"),
     * or "Expired" if the expiry time has passed.
     */
    fun calculateRemainingDuration(expiryTimeMillis: Long, currentTimeMillis: Long = System.currentTimeMillis()): String {
        val diff = expiryTimeMillis - currentTimeMillis

        if (diff <= 0) {
            return "Expired"
        }

        val days = TimeUnit.MILLISECONDS.toDays(diff)
        val hours = TimeUnit.MILLISECONDS.toHours(diff) % 24
        val minutes = TimeUnit.MILLISECONDS.toMinutes(diff) % 60
        val seconds = TimeUnit.MILLISECONDS.toSeconds(diff) % 60

        val result = kotlin.text.StringBuilder()
        if (days > 0) result.append("$days day(s) ")
        if (hours > 0) result.append("$hours hour(s) ")
        if (minutes > 0) result.append("$minutes minute(s) ")
        if (seconds > 0) result.append("$seconds second(s) ")

        return result.toString().trim()
    }

    /**
     * Parses a duration string (e.g., "1d12h") into a total number of milliseconds.
     *
     * @param durationString The input string containing duration parts like "1y2mo3d".
     * @return The total duration in milliseconds as a Long.
     */
    fun parseDurationStringToMillis(durationString: String): Long {
        // First, calculate the total number of seconds using the existing helper function.
        // This correctly handles summing up all parts of the string (e.g., "1d" + "12h").
        val totalSeconds = parseDurationToSeconds(durationString)

        // Then, convert the total seconds to milliseconds.
        return totalSeconds * 1000L
    }

    /**
     * @param durationString The input string containing duration parts.
     * - Valid units are s, m, h, d, w, mo, y.
     * @return A formatted string like "12 hours 10 minutes 30 seconds".
     */
    fun formatDuration(durationString: String): String {
        // Regex to find all number-unit pairs.
        val pattern = """(\d+)(mo|[smhdwy])""".toRegex()

        val matches = pattern.findAll(durationString.lowercase())

        // If no matches are found, the format is invalid.
        if (!matches.any()) {
            return "Invalid duration format"
        }

        // Process each match and convert it into a readable string part.
        val formattedParts = matches.map { matchResult ->
            val (valueStr, unit) = matchResult.destructured
            val value = valueStr.toLong()

            val unitName = when (unit) {
                "s" -> "second"
                "m" -> "minute"
                "h" -> "hour"
                "d" -> "day"
                "w" -> "week"
                "mo" -> "month"
                "y" -> "year"
                else -> "" // should not happen due to the regex pattern.
            }

            if (value == 1L) {
                "$value $unitName"
            } else {
                "$value ${unitName}s"
            }
        }.toList()

        return formattedParts.joinToString(" ")
    }

    fun isExpired(redeemCode: RedeemCode): Boolean {
        if (redeemCode.duration == "0s") return false
        val time = redeemCode.validFrom
        val duration = redeemCode.duration

        val expiryTimeMillis = time.time + parseDurationToSeconds(duration) * 1000
        return currentTimeMillis.time > expiryTimeMillis  //29oct > 30oct (false)
    }

    fun parseSecondsToDuration(seconds: Long): String {
        val timeUnitToSeconds = mapOf(
            "y" to 31536000L, "mo" to 2592000L, "d" to 86400L, "h" to 3600L, "m" to 60L, "s" to 1L
        )
        val sortedUnits = timeUnitToSeconds.entries.sortedByDescending { it.value }
        val result = StringBuilder()
        var remainingSeconds = seconds

        for ((unit, secondsInUnit) in sortedUnits) {
            if (remainingSeconds >= secondsInUnit) {
                val amount = remainingSeconds / secondsInUnit
                remainingSeconds %= secondsInUnit
                result.append("${amount}${unit}")
            }
        }
        return result.toString()
    }

    fun parseDurationToSeconds(duration: String): Long {
        val regex = """(\d+)(y|mo|d|h|m|s)""".toRegex()
        val timeUnitToSeconds = mapOf(
            "y" to 31536000L, "mo" to 2592000L, "d" to 86400L, "h" to 3600L, "m" to 60L, "s" to 1L
        )

        return regex.findAll(duration).sumOf { match ->
            val value = match.groupValues[1].toLongOrNull() ?: 0L
            val unit = match.groupValues[2]
            value * (timeUnitToSeconds[unit] ?: 0L)
        }
    }

    fun isDurationValid(duration: String): Boolean {
        if (duration.isBlank()) return false
        if (duration.length < 2) return false

        // Define valid units dynamically
        val validUnits = listOf("y", "mo", "d", "h", "m", "s").joinToString("|")
        val pattern = Regex("""^(\d+($validUnits))+$""")

        // Match against the pattern and ensure numbers are valid
        return pattern.matches(duration) && Regex("""\d+""").findAll(duration).all { it.value.toInt() >= 0 }
    }

    fun onCoolDown(cooldown: String, lastRedeemedTimeMillis: Long): Boolean {
        if (!isDurationValid(cooldown)) return false
        if (cooldown == "0s") return false
        val cooldownTimeMillis = parseDurationToSeconds(cooldown) * 1000
        return currentTimeMillis.time < lastRedeemedTimeMillis + cooldownTimeMillis
        //Example: 29oct < 28oct + 2d = 30oct (true) [Where 29oct -> current date]
    }

    fun adjustDuration(existingDuration: String, adjustmentDuration: String, isAdding: Boolean): String {
        val totalExistingSeconds = parseDurationToSeconds(existingDuration)
        val totalAdjustmentSeconds = parseDurationToSeconds(adjustmentDuration)

        val adjustedSeconds = if (isAdding) totalExistingSeconds + totalAdjustmentSeconds else totalExistingSeconds - totalAdjustmentSeconds
        if (adjustedSeconds <= 0) return "0s"

        return parseSecondsToDuration(adjustedSeconds)
    }

}