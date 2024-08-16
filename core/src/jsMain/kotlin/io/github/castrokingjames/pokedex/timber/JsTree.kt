package io.github.castrokingjames.pokedex.timber

import timber.log.Timber
import timber.log.Tree

class JsTree constructor(private val defaultTag: String = "App") : Tree() {


    override fun performLog(priority: Int, tag: String?, throwable: Throwable?, message: String?) {
        val sb = StringBuilder()
        sb.append(defaultTag)
        sb.append(" ")
        if (message != null) {
            sb.append(message)
            sb.append(" ")
        }
        if (throwable != null) {
            sb.append(throwable)
        }
        when (priority) {
            Timber.ERROR -> console.error(sb.toString())
            else -> console.log(sb.toString())
        }
    }
}
