package com.drm.learning.javatokt

import kotlin.math.pow

infix fun Int.soma(a:Int):Int = this + a

fun Number.toPowerOf(exponent: Number): Double {
    return this.toDouble().pow(exponent.toDouble())
}

fun checkUserStatus(): String = "Online"

inline fun <T> executeWithRetry(
    predicate: (cause: Throwable) -> Boolean = { true },
    retries: Int = 1,
    call: () -> T
): T? {
    for (i in 0..retries) {
        return try {
            call()
        } catch (e: Exception) {
            if (predicate(e) && i < retries) {
                continue
            } else throw e
        }
    }
    return null
}