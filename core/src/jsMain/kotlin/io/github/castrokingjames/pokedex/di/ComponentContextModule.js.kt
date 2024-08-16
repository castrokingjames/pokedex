package io.github.castrokingjames.pokedex.di

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.koin.dsl.bind
import org.koin.dsl.module

actual val componentContextModule = module {

    single {
        LifecycleRegistry()
    } bind Lifecycle::class

    single {
        DefaultComponentContext(get())
    } bind ComponentContext::class
}
