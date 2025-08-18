package api.justlime.redeemcodex.models 

data class RedeemLog (
    val id: Int,
    val playerUUID: String,
    val code: String,
    val redeemedAt: Long
)