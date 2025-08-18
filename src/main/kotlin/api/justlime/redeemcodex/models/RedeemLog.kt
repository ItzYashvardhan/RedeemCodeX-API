package api.justlime.redeemcodex.models

import java.sql.Timestamp
import java.util.UUID

data class RedeemLog (
    val id: Int,
    val playerUUID: UUID,
    val code: String,
    val redeemedAt: Timestamp
)