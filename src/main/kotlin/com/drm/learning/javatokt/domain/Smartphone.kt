package com.drm.learning.javatokt.domain

open class Smartphone()

class Iphone : Smartphone()

class Android : Smartphone()

inline fun <reified T : Smartphone> List<Smartphone>.findByType(): T? =
    find { it is T } as T