package api.justlime.redeemcodex.models

import java.sql.Timestamp
import java.util.UUID

data class PlayerCoupon(
    val id: Int,
    val playerUuid: UUID,
    val code: String,
    var isClaimed: Boolean,
    val giftedAt: Timestamp
)