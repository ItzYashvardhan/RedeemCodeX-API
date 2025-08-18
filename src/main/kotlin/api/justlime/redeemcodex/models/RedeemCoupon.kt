package api.justlime.redeemcodex.models

import java.sql.Timestamp
import java.util.UUID

data class RedeemCoupon(
    val id: Int,
    val uuid: UUID,
    val code: String,
    val giftedAt: Timestamp
)