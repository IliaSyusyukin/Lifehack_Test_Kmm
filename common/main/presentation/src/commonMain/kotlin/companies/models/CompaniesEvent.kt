package companies.models

import models.Company

sealed class CompaniesEvent {
    object QueryChanged : CompaniesEvent()
    class CompanyClicked(val company: Company) : CompaniesEvent()
}