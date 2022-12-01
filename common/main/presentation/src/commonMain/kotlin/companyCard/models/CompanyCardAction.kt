package companies.models

import models.Company

sealed class CompanyCardAction {
    class ShowCompanyDetail(val company: Company) : CompanyCardAction()
}