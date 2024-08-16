package io.github.castrokingjames.pokedex.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import io.github.castrokingjames.pokedex.platform.Platform
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.coroutines.CoroutineContext

class DefaultPokedexComponent constructor(
    componentContext: ComponentContext,
    coroutineContext: CoroutineContext,
) : PokedexComponent, ComponentContext by componentContext, KoinComponent {

    private val platform: Platform by inject<Platform>()

    override val name: String = platform.name()

    private val scope = coroutineScope(coroutineContext + SupervisorJob())

    private val _timer = MutableStateFlow(0L)
    override val timer = _timer.asStateFlow()

    private var job: Job? = null

    override fun startTimer() {
        job?.cancel()
        job = scope.launch {
            while (true) {
                delay(1000)
                _timer.value++
            }
        }
    }
}
