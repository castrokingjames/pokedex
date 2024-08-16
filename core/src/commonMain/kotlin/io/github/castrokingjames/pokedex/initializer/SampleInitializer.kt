package io.github.castrokingjames.pokedex.initializer

import timber.log.Timber
import timber.log.error

class SampleInitializer : Initializer {

    override fun invoke() {
        Timber.error { "Initializing 123" }
    }
}