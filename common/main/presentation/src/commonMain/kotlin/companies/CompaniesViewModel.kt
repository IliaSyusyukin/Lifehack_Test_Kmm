package companies

import CompaniesRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import companies.models.CompaniesAction
import companies.models.CompaniesEvent
import companies.models.CompaniesViewState
import companies.models.CompanyCardAction
import di.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import models.Company

class CompaniesViewModel : BaseSharedViewModel<CompaniesViewState, CompaniesAction, CompaniesEvent>(
    initialState = CompaniesViewState()
) {

    private val companiesRepository: CompaniesRepository = Inject.instance()
    private var showCompaniesJob: Job? = null

    init {
        showCompanies()
    }

    override fun obtainEvent(viewEvent: CompaniesEvent) {
        when (viewEvent) {
            is CompaniesEvent.CompanyClicked ->
            {
                showDetailedGame(viewEvent.company)
                println("!!!Company clicked = ${viewEvent.company}")
            }
            is CompaniesEvent.QueryChanged -> {
                //viewAction = CompaniesAction.ShowCompanies
                showCompanies()
            }
        }
    }

    private fun showDetailedGame(company: Company) {
        viewAction = CompaniesAction.ShowCompanyDetail(company = company)
    }

    private fun showCompanies() {
        showCompaniesJob = viewModelScope.launch {
            viewState = viewState.copy()
            showCompaniesJob?.cancel()
            delay(500)
            viewState = try {
                println("Start showCompanies")
                val companiesResponse = companiesRepository.fetchAllCompanies()
                println("${companiesResponse.get(0).companyName}")
                //viewAction = CompaniesAction.ShowCompanies
                viewState.copy(companies = companiesResponse)
            } catch (e:Exception) {
                println("Error showCompanies")
                println(e.localizedMessage)
                viewState.copy(companies = emptyList())
            }
        }
    }
}