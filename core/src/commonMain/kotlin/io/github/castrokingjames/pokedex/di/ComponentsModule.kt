package io.github.castrokingjames.pokedex.di

import io.github.castrokingjames.pokedex.di.annotation.Dispatcher
import io.github.castrokingjames.pokedex.ui.DefaultPokedexComponent
import io.github.castrokingjames.pokedex.ui.PokedexComponent
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val componentsModule = module {
    includes(componentContextModule)

    single {
        DefaultPokedexComponent(get(), get(named<Dispatcher.Main>()))
    } bind PokedexComponent::class
}
