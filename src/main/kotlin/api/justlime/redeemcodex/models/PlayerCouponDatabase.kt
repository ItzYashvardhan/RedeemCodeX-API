package api.justlime.redeemcodex.models

import java.sql.Timestamp
import java.util.UUID

data class PlayerCouponDatabase(
    val id: Int,
    val uuid: UUID,
    val code: String,
    val claimedAtList: String,
    val giftedAt: Timestamp
)