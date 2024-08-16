package io.github.castrokingjames.pokedex.android

import android.app.Application
import io.github.castrokingjames.pokedex.di.initKoin
import io.github.castrokingjames.pokedex.initializer.StartupInitializer
import org.koin.android.ext.koin.androidContext

class PokedexApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val koin = initKoin {
            androidContext(this@PokedexApplication)
        }.koin
        val initializer = koin.get<StartupInitializer>()
        initializer()
    }
}