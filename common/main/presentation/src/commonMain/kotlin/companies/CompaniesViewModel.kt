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

//    val companies = Pager(
//        pagingSourceFactory = { RecipesPagingSource(recipesRepository) },
//        config = PagingConfig(pageSize = 20)
//    ).flow.cachedIn(viewModelScope)

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
                viewAction = CompaniesAction.ShowCompanies
                showCompanies()
            }
        }
    }

    private fun showDetailedGame(company: Company) {
        viewAction = CompaniesAction.ShowCompanyDetail(company = company)
    }

    private fun showCompanies() {
        showCompaniesJob = viewModelScope.launch {
            viewState = viewState.copy(companies = emptyList(), isLoaded = false)
            showCompaniesJob?.cancel()
            delay(2000)
            viewState = try {
                println("Start showCompanies")
                val companiesResponse = companiesRepository.fetchAllCompanies()
                println("${companiesResponse.get(0).companyName}")
                //viewAction = CompaniesAction.ShowCompanies
                viewState.copy(companies = companiesResponse, isLoaded = true)
            } catch (e:Exception) {
                println("Error showCompanies")
                println(e.localizedMessage)
                viewState.copy(companies = emptyList(), isLoaded = false)
            }
        }
    }
}