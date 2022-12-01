package companyCard

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import companies.models.CompanyCardAction
import models.Company
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun CompanyCardScreen(company: Company) {
    val rootController = LocalRootController.current

    StoredViewModel({ CompanyCardViewModel(company) }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()

        CompanyCardView(viewState.value) {
            viewModel.obtainEvent(it)
        }

        when (viewAction.value) {
//            is CompanyCardAction.ShowCompanyDetail -> rootController.findRootController()
//                .present(NavigationTree.Main.CompanyDetail.name)

            is CompanyCardAction.ShowCompanyDetail -> rootController.push(
                NavigationTree.Main.CompanyDetail.name, company
            )

            else -> {}
        }
    }
}