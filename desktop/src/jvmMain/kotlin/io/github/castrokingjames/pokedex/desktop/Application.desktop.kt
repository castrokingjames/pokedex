package io.github.castrokingjames.pokedex.desktop

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.windowsizeclass.LocalWindowSizeClassProvider
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass.Companion.calculateFromSize
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.github.castrokingjames.pokedex.PokeDexTheme
import io.github.castrokingjames.pokedex.di.initKoin
import io.github.castrokingjames.pokedex.initializer.StartupInitializer
import io.github.castrokingjames.pokedex.ui.PokedexApp
import io.github.castrokingjames.pokedex.ui.PokedexComponent

private val koin = initKoin {}.koin

fun main() {
    val initializer = koin.get<StartupInitializer>()
    initializer()
    val component = koin.get<PokedexComponent>()
    application {
        Window(
            title = "Pokedex",
            onCloseRequest = ::exitApplication
        ) {
            BoxWithConstraints {
                val windowSizeClass: WindowSizeClass = calculateFromSize(DpSize(maxWidth, maxHeight))
                CompositionLocalProvider(LocalWindowSizeClassProvider provides windowSizeClass) {
                    PokeDexTheme {
                        PokedexApp(component)
                    }
                }
            }
        }
    }
}
