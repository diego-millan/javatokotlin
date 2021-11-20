package com.drm.learning.javatokt.functions

fun sumType(x : Any) : Int {
    return when (x) {
        is Int -> (x + 1)
        is String -> (x.length + 1)
        is IntArray -> (x.sum())
        else -> 0
    }
}

fun sayHello(name : String) : Unit {
    println("Hello $name")
}
