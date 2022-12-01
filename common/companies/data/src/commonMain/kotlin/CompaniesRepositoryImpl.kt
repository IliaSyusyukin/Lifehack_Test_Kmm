import ktor.KtorCompaniesDataSource
import ktor.models.mapToCompany
import ktor.models.mapToCompanyDetail
import models.Company
import models.CompanyCard

class CompaniesRepositoryImpl(
    private val remoteDataSource: KtorCompaniesDataSource
) : CompaniesRepository {

    override suspend fun fetchAllCompanies(): List<Company> {
        return remoteDataSource.fetchAllCompanies().map { it.mapToCompany() }
    }

    override suspend fun detailCompany(id: Int): List<CompanyCard> {
        return remoteDataSource.detailCompany(id).map { it.mapToCompanyDetail() }
    }
}