package ktor.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import models.Company
import models.CompanyCard

@Serializable
data class KtorCompanyDetail(
    @SerialName("id") val companyId: String,
    @SerialName("name") val companyName: String,
    @SerialName("img") val companyImg: String,
    @SerialName("description") val companyDescription: String,
    @SerialName("www") val companySite: String,
    @SerialName("phone") val companyPhone: String,
    @SerialName("lat") val companyLat: Double,
    @SerialName("lon") val companyLong: Double,
)

fun KtorCompanyDetail.mapToCompanyDetail(): CompanyCard =
    CompanyCard(
        companyCardId = companyId,
        companyCardName = companyName,
        companyCardImg = companyImg,
        companyCardDesc = companyDescription,
        companyCardSite = companySite,
        companyCardPhone = companyPhone,
        companyCardLat = companyLat,
        companyCardLong = companyLong
    )