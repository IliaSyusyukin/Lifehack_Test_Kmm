import ktor.KtorCompaniesDataSource
import org.kodein.di.*

val companiesModule = DI.Module("companiesModule") {
    bind<KtorCompaniesDataSource>() with provider {
        KtorCompaniesDataSource(instance())
    }

    bind<CompaniesRepository>() with singleton {
        CompaniesRepositoryImpl(instance())
    }
}