package com.drm.learning.javatokt

import kotlin.math.pow

infix fun Int.soma(a:Int):Int = this + a

fun Number.toPowerOf(exponent: Number): Double {
    return this.toDouble().pow(exponent.toDouble())
}

fun checkUserStatus(): String = "Online"