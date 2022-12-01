package companies.models

import models.CompanyCard

data class CompanyCardViewState(
    val query: Int = 0,
    val companyDetail: List<CompanyCard> = emptyList()
)