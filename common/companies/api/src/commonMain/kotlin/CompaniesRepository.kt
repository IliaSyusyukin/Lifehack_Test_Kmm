import models.Company
import models.CompanyCard

interface CompaniesRepository {
    suspend fun fetchAllCompanies(): List<Company>
    suspend fun detailCompany(id: Int): List<CompanyCard>
}