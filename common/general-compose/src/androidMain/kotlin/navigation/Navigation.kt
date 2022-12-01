package navigation

import companies.CompaniesScreen
import companyCard.CompanyCardScreen
import models.Company
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.generateGraph() {
//    screen(name = NavigationTree.Splash.SplashScreen.name) {
//        SplashScreen()
//    }

    screen(name = NavigationTree.Main.Companies.name) {
        //Text("Hello, Game Detail", color = Color.White)
        CompaniesScreen()
    }

    screen(name = NavigationTree.Main.CompanyDetail.name) {
        CompanyCardScreen(company = it as Company)
    }

    //authFlow()
    //mainFlow()
}
