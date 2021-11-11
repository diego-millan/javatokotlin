package com.drm.learning.javatokt.classes

import com.drm.learning.javatokt.domain.Cat
import com.drm.learning.javatokt.domain.Dog
import com.drm.learning.javatokt.domain.Pet
import com.drm.learning.javatokt.domain.enums.SemaphoreEnum
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

    @Test
    fun `when use enum functions, should return as declared`() {
        val greenSemaphore = SemaphoreEnum.MOVE
        Assertions.assertEquals("Green", greenSemaphore.color())
    }
}