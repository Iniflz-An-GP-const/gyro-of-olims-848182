package milagros.gyroofolims.mobile

import android.app.Application
import milagros.gyroofolims.mobile.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MOOSEApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MOOSEApplication)
            modules(appModules)
        }
    }
}