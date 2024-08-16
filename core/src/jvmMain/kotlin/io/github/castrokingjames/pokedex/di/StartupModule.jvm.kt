package io.github.castrokingjames.pokedex.di

import io.github.castrokingjames.pokedex.di.annotation.Dispatcher
import io.github.castrokingjames.pokedex.initializer.Initializer
import io.github.castrokingjames.pokedex.initializer.StartupInitializer
import io.github.castrokingjames.pokedex.initializer.TimberInitializer
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

actual val startupModule = module {

    singleOf(::StartupInitializer) {
        bind<Initializer>()
    }

    singleOf(::TimberInitializer) {
        bind<Initializer>()
    }

    single {
        StartupInitializer(getAll(), get(named<Dispatcher.IO>()))
    }
}
