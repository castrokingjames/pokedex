package androidx.compose.material3.windowsizeclass

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf

val LocalWindowSizeClassProvider: ProvidableCompositionLocal<WindowSizeClass> =
    staticCompositionLocalOf { error("No window size class provided") }