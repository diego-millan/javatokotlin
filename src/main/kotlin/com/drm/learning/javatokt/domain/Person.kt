package com.drm.learning.javatokt.domain

import java.util.Date

data class Person(
    val name: String,
    val address: String,
    val zipCode: String,
    val age: Int,
    val birthDate: Date
)
