package companies.models

import models.Company

sealed class CompaniesAction {
    class ShowCompanyDetail(val company: Company) : CompaniesAction()
    object ShowCompanies : CompaniesAction()
}