package io.github.castrokingjames.pokedex.platform

actual class Platform(private val context: AndroidContext) {

    actual fun name(): String {
        return "Android: ${context.context.packageName}"
    }
}
