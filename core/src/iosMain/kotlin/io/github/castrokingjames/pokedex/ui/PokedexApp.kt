package io.github.castrokingjames.pokedex.ui

import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.LocalWindowSizeClassProvider
import androidx.compose.runtime.Composable

@Composable
fun PokedexApp() {
    val windowSizeClass = LocalWindowSizeClassProvider.current
    Text(
        text = "Size: $windowSizeClass"
    )
}
