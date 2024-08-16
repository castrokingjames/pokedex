package io.github.castrokingjames.pokedex.initializer

import io.github.castrokingjames.pokedex.BuildConfig
import io.github.castrokingjames.pokedex.timber.AndroidTree
import timber.log.Timber

actual class TimberInitializer : Initializer {

    actual override fun invoke() {
        if (BuildConfig.DEBUG) {
            Timber.plant(AndroidTree("Pokedex"))
        }
    }
}
