import di.Inject
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.direct
import org.kodein.di.singleton

object PlatformSDK {

    fun init(
        configuration: PlatformConfiguration
    ) {
        val commonModule = DI.Module(
            name = "common",
            init = {
                bind<PlatformConfiguration>() with singleton { configuration }
            }
        )

        Inject.createDependencies(
            DI {
                importAll(
                    commonModule,
                    coreModule,
                    companiesModule
                )
            }.direct
        )
    }
}