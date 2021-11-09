package com.drm.learning.javatokt.classes

import com.drm.learning.javatokt.domain.Cat
import com.drm.learning.javatokt.domain.Dog
import com.drm.learning.javatokt.domain.Pet
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class InitializeClassesTest {

    @Test
    fun `when check method apply then it should work like builder`() {
        val dog : Pet = Dog().apply {
            name = "barto"
            gender = "male"
        }

        Assertions.assertEquals("barto", dog.name)
    }

    @Test
    fun `when initialize variables then it should work like Java`() {
        val cat : Pet = Cat()
        cat.name = "Florence"
        cat.gender = "female"

        Assertions.assertEquals("Florence", cat.name)
    }
}