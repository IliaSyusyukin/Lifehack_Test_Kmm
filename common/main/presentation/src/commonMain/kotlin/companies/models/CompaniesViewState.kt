package companies.models

import models.Company

data class CompaniesViewState(
    val companies: List<Company> = emptyList()
)