package io.github.castrokingjames.pokedex.ui

import kotlinx.coroutines.flow.StateFlow

interface PokedexComponent {

    val name: String

    val timer: StateFlow<Long>

    fun startTimer()
}