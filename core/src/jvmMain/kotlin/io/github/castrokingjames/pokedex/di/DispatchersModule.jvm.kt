package io.github.castrokingjames.pokedex.di

import io.github.castrokingjames.pokedex.di.annotation.Dispatcher
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

actual val dispatchersModule = module {

    single(named<Dispatcher.IO>()) {
        kotlinx.coroutines.Dispatchers.IO
    } bind CoroutineContext::class

    single(named<Dispatcher.IO>()) {
        kotlinx.coroutines.Dispatchers.IO
    } bind CoroutineDispatcher::class

    single(named<Dispatcher.Main>()) {
        kotlinx.coroutines.Dispatchers.Main
    } bind CoroutineContext::class

    single(named<Dispatcher.Main>()) {
        kotlinx.coroutines.Dispatchers.Main
    } bind CoroutineDispatcher::class
}
