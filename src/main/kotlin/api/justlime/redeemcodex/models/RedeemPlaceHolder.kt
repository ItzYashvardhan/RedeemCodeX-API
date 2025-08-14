package api.justlime.redeemcodex.models 

data class RedeemPlaceHolder(
    var can_redeem: Boolean = false,
    val total_redemption: Int = 0,
    val total_unique_redemption: Int = 0,
    val total_redemption_template: Int = 0,
    val codes: String = "",
    val codes_template: String = "",
    val total_codes: Int =0,
    val total_templates: Int = 0,
    val total_template: Int = 0,
    var status: String =""
)