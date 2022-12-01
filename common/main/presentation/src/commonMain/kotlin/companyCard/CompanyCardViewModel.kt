package companyCard

import CompaniesRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import companies.models.*
import di.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import models.Company

class CompanyCardViewModel(val company: Company) : BaseSharedViewModel<CompanyCardViewState, CompanyCardAction, CompanyCardEvent>(
    initialState = CompanyCardViewState()
) {

    private val companiesRepository: CompaniesRepository = Inject.instance()
    private var showCompanyCardJob: Job? = null

    init {
        showCompanyDetail(company.companyId.toInt())
    }

    override fun obtainEvent(viewEvent: CompanyCardEvent) {
        when (viewEvent) {
            is CompanyCardEvent.Query -> {
                showCompanyDetail(viewEvent.id)
            }
            else -> {}
        }
    }

    private fun showCompanyDetail(id: Int) {
        showCompanyCardJob = viewModelScope.launch {
            viewState = viewState.copy(query = id)
            showCompanyCardJob?.cancel()
            //delay(500)
            viewState = try {
                println("Start showCompanies")
                val companyDetailResponse = companiesRepository.detailCompany(id)
                println("${companyDetailResponse.get(0)}")
                //viewAction = CompaniesAction.ShowCompanies
                viewState.copy(companyDetail = companyDetailResponse)
            } catch (e:Exception) {
                println("Error showCompanies")
                println(e.localizedMessage)
                viewState.copy(companyDetail = emptyList())
            }
        }
    }
}