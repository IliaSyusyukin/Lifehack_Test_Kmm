package ktor.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import models.Company

@Serializable
data class KtorCompany(
    @SerialName("id") val companyId: String,
    @SerialName("name") val companyName: String,
    @SerialName("img") val companyImg: String
)

fun KtorCompany.mapToCompany(): Company =
    Company(
        companyId = companyId,
        companyName = companyName,
        companyImg = companyImg
    )