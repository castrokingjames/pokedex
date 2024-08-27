/*
 * Copyright 2024, King James Castro and project contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.castrokingjames.pokedex.js

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.windowsizeclass.LocalWindowSizeClassProvider
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass.Companion.calculateFromSize
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.window.CanvasBasedWindow
import io.github.castrokingjames.pokedex.PokeDexTheme
import io.github.castrokingjames.pokedex.di.initKoin
import io.github.castrokingjames.pokedex.initializer.StartupInitializer
import io.github.castrokingjames.pokedex.ui.PokedexApp
import io.github.castrokingjames.pokedex.ui.PokedexComponent
import org.jetbrains.skiko.wasm.onWasmReady

private val koin =
  initKoin {
    properties(mapOf("debug" to true))
  }.koin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
  val initializer = koin.get<StartupInitializer>()
  initializer()
  val component = koin.get<PokedexComponent>()
  onWasmReady {
    CanvasBasedWindow(title = "Pokedex") {
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
