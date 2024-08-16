package io.github.castrokingjames.pokedex.platform

actual class Platform(val context: JsContext) {

    actual fun name(): String {
        return context.packageName
    }
}