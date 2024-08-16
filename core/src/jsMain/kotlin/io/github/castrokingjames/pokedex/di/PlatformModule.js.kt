package io.github.castrokingjames.pokedex.di

import io.github.castrokingjames.pokedex.platform.JsContext
import io.github.castrokingjames.pokedex.platform.Platform
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule = module {

    single {
        JsContext()
    }

    singleOf(::Platform)
}