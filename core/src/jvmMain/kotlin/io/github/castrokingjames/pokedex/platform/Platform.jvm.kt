package io.github.castrokingjames.pokedex.platform

actual class Platform(private val context: JvmContext) {

    actual fun name(): String {
        return context.packageName
    }
}
