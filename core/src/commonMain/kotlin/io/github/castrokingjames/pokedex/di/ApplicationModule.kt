package io.github.castrokingjames.pokedex.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(declaration: KoinAppDeclaration = {}): KoinApplication {
    return startKoin {
        declaration()
        modules(
            applicationModule
        )
    }
}

val applicationModule = module {
    includes(
        dispatchersModule,
        startupModule,
        componentsModule,
        platformModule
    )
}
