package io.github.castrokingjames.pokedex.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.LocalWindowSizeClassProvider
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.CompositionLocalProvider
import com.arkivanov.decompose.defaultComponentContext
import io.github.castrokingjames.pokedex.PokeDexTheme
import io.github.castrokingjames.pokedex.ui.PokedexApp
import io.github.castrokingjames.pokedex.ui.PokedexComponent
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component by inject<PokedexComponent> {
            parametersOf(defaultComponentContext())
        }

        setContent {
            val windowSizeClass: WindowSizeClass = calculateWindowSizeClass(this)
            CompositionLocalProvider(LocalWindowSizeClassProvider provides windowSizeClass) {
                PokeDexTheme {
                    PokedexApp(component)
                }
            }
        }
    }
}
