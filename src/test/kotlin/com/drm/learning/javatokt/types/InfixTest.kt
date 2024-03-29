package com.drm.learning.javatokt.types

import com.drm.learning.javatokt.checkUserStatus
import com.drm.learning.javatokt.domain.enums.SemaphoreEnum
import com.drm.learning.javatokt.executeWithRetry
import com.drm.learning.javatokt.soma
import com.drm.learning.javatokt.toPowerOf
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class InfixTest {

    @Test
    fun `when create a sum using infix, it should sum first int with the second`() {
        val x = 10
        val y = x soma 5
        Assertions.assertEquals(15, y)
    }

    @Test
    fun `when use extension function of power of a number, it should multiply by itself exponent times`() {
        val x = 3
        val result = x.toPowerOf(3)
        Assertions.assertEquals(27.0, result)
    }

    @Test
    fun `when use top-level function, it should work without needed to call method class before or instantiate it`(){
        Assertions.assertEquals("online", checkUserStatus())
    }

    @Test
    fun `when call throws specific exception, retry should work properly`() {
        var retries = 0
        var exceptionsThrow = 0
        try {
            executeWithRetry({ e ->
                (e is IllegalArgumentException).also { if (it) retries++ }
            }) {
                SemaphoreEnum.valueOf("invalid")
            }
        } catch (e: IllegalArgumentException) {
            exceptionsThrow++
        }
        Assertions.assertEquals(2, retries)
        Assertions.assertEquals(exceptionsThrow, 1)
    }
}