package com.drm.learning.javatokt.domain.enums

enum class SemaphoreEnum {
    STOP {
        override fun color() = "Red"
    },
    ALERT {
        override fun color() = "Yellow"
    },
    MOVE {
        override fun color() = "Green"
    };

    abstract fun color(): String
}