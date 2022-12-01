package models

data class CompanyCard(
    val companyCardId: String,
    val companyCardName: String,
    val companyCardImg: String,
    val companyCardDesc: String,
    val companyCardSite: String,
    val companyCardPhone: String,
    val companyCardLat: Double,
    val companyCardLong: Double,
)
