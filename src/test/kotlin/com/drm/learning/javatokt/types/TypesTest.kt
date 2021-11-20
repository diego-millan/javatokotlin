package com.drm.learning.javatokt.types

import com.drm.learning.javatokt.functions.sumType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TypesTest {

    @Test
    fun `when use Any type then it should work as Java Object`() {
        val integerType = 2
        val integerResult = sumType(integerType)
        Assertions.assertEquals(3, integerResult)

        val stringType = "My String"
        val stringResult = sumType(stringType)
        Assertions.assertEquals(10, stringResult)
    }


}