package com.drm.learning.javatokt.domain

abstract class Pet {
    lateinit var name : String
    lateinit var gender : String

    abstract fun talk() : String

    fun print() {
        println("animal name is $name and its gender is $gender")
    }
}