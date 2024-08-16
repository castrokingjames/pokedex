package io.github.castrokingjames.pokedex.timber

import timber.log.Timber
import timber.log.Tree

class JvmTree @JvmOverloads constructor(private val defaultTag: String = "App") : Tree() {


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
            Timber.ERROR -> System.err.println(sb)
            else -> println(sb)
        }
    }
}
