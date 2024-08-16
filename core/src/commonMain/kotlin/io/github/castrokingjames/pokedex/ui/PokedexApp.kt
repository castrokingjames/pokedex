package io.github.castrokingjames.pokedex.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.LocalWindowSizeClassProvider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState

@Composable
fun PokedexApp(component: PokedexComponent) {
    val timer = component
        .timer
        .collectAsState()

    LaunchedEffect(Unit) {
        component.startTimer()
    }

    val windowSizeClass = LocalWindowSizeClassProvider.current

    Column {
        Text(
            text = "Platform: ${component.name}"
        )
        Text(
            text = "Value: ${timer.value}"
        )
    }
}
