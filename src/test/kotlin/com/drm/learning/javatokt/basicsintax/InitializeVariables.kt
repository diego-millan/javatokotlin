package com.drm.learning.javatokt.basicsintax

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class InitializeVariables {

    lateinit var strWithLateInit : String
    lateinit var str2WithLateInit : String

    var stringWithCustomSetter : String = ""
        set(value) {
            field = "custom setter: $value"
        }

    @Test
    fun `when use var and val, check the difference between them`() {
        val str = "value"
//        str = "value changed"  -- Syntax error, val is not mutable

        val strWithExplicitType : String = "" // same type as str

        var strMutable  = "firstValue"
        strMutable = "secondValue"
        //        strMutable = null -- Syntax error, can't be set to null

        Assertions.assertTrue(str is String)
        Assertions.assertEquals("secondValue", strMutable)
    }

    @Test
    fun `when creating a nullable var, null could be assigned to it`() {
        var notNullableStr : String = ""
//        notNullableStr = null -- Syntax error, can't be set to null
        val nullableStr : String? = null // can be set to null
    }


    @Test
    fun `when try to access a lateinit variable never initialized then throws exception` () {
        str2WithLateInit = "valueAssigned"

        Assertions.assertTrue(this@InitializeVariables::str2WithLateInit.isInitialized)

        assertThrows<UninitializedPropertyAccessException> {
            strWithLateInit.length
        }
    }

    @Test
    fun `when a variable setter is customized, it should be used instead of default setter`(){
        stringWithCustomSetter = "new value"
        Assertions.assertEquals( "custom setter: new value", stringWithCustomSetter )
    }
}