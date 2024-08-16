package io.github.castrokingjames.pokedex.initializer

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class StartupInitializer constructor(
    val initializers: List<Initializer>,
    val dispatcher: CoroutineDispatcher,
) : Initializer {

    override fun invoke() {
        val context = CoroutineScope(dispatcher)
        context.launch {
            initializers.forEach(Initializer::invoke)
        }
    }
}