package navigation

import androidx.compose.material.Text
import companies.CompaniesScreen
//import home.HomeScreen
import navigation.tabs.*
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.mainFlow() {
    bottomNavigation(
        name = NavigationTree.Main.Companies.name,
        tabsNavModel = BottomConfiguration()
    ) {
        tab(CompaniesTab()) {
            screen(name = NavigationTree.Main.Companies.name) {
                CompaniesScreen()
            }

//            screen(name = NavigationTree.Main.Profile.name) {
//                Text("Hello, Profile")
//            }
        }

//        tab(SearchTab()) {
//            screen(name = NavigationTree.Main.Home.name) {
//                CompaniesScreen()
//            }
//        }

    }
}