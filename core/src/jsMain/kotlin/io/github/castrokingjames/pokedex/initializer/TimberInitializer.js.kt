package io.github.castrokingjames.pokedex.initializer

import io.github.castrokingjames.pokedex.timber.JsTree
import timber.log.Timber

actual class TimberInitializer : Initializer {

    actual override fun invoke() {
        Timber.plant(JsTree("Pokedex"))
    }
}
