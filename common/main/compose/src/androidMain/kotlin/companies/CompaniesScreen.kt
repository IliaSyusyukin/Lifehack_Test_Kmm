package companies

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import companies.models.CompaniesAction
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun CompaniesScreen() {
    val rootController = LocalRootController.current

    StoredViewModel({ CompaniesViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()

        CompaniesView(viewState.value) {
            viewModel.obtainEvent(it)
        }

        when (val action = viewAction.value) {
            is CompaniesAction.ShowCompanyDetail -> {
//                rootController.findRootController()
//                    .present(NavigationTree.Main.CompanyDetail.name)

                rootController.push(NavigationTree.Main.CompanyDetail.name, action.company)
            }

            is CompaniesAction.ShowCompanies -> rootController.findRootController()
                .present(NavigationTree.Main.Companies.name)
            null -> {}
        }
    }
}