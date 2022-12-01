package navigation

object NavigationTree {

    enum class Splash {
        SplashScreen
    }

    enum class Auth {
        AuthFlow, Login
    }

    enum class Main {
        Dashboard, Companies, CompanyDetail
    }
}