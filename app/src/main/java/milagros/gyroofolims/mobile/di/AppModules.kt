package milagros.gyroofolims.mobile.di

import androidx.room.Room
import milagros.gyroofolims.mobile.data.database.MOOSEAppDatabase
import milagros.gyroofolims.mobile.data.repository.HighScoreRepository
import milagros.gyroofolims.mobile.data.model.Difficulty
import milagros.gyroofolims.mobile.ui.viewmodel.GameViewModel
import milagros.gyroofolims.mobile.ui.viewmodel.HighScoreViewModel
import milagros.gyroofolims.mobile.ui.viewmodel.MenuViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private const val DB_NAME = "moose_db"

val dataModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = MOOSEAppDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<MOOSEAppDatabase>().highScoreDao() }

    single {
        HighScoreRepository(
            highScoreDao = get(),
            coroutineDispatcher = get(DispatchersQualifiers.IO)
        )
    }
}

val viewModule = module {
    viewModel { (difficulty: Difficulty) ->
        GameViewModel(difficulty = difficulty, highScoreRepository = get())
    }

    viewModel { HighScoreViewModel(highScoreRepository = get()) }

    viewModel { MenuViewModel(highScoreRepository = get()) }
}

val appModules: List<Module> = listOf(dispatcherModule, dataModule, viewModule)
