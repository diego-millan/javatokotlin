package com.drm.learning.javatokt.types

import com.drm.learning.javatokt.functions.sumType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.util.Assert
import java.lang.RuntimeException

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

    @Test
    fun `when use add to mutable list then it should add the item in the end`(){
        val mutableStringList = mutableListOf<String>()
        mutableStringList.add("item1")
        mutableStringList.add("item2")

        Assertions.assertEquals("item1", mutableStringList[0])

        mutableStringList.remove("item1")
        Assertions.assertEquals("item2", mutableStringList[0])
    }

    @Test
    fun `when use add and remove to mutable map then it should work properly`(){
        val mutableMap : MutableMap<String, Int> = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
        mutableMap["d"] = 4
        mutableMap.remove("c")

        Assertions.assertEquals(1, mutableMap["a"])
        Assertions.assertEquals(4, mutableMap["d"])
        Assertions.assertFalse(mutableMap.containsKey("c"))
    }

    @Test
    fun `when get triple by x value, should return properly`() {
        val triple: Triple<String, String, Int> = Triple("firstValue","secondValue", 1)

    }

    @Test
    fun test() {
        val mutableMap: MutableMap<String, String> = mutableMapOf("a" to "c")
        try {
            mutableMap["F"]
            throw RuntimeException("eeeee")
        } catch (e : Exception) {
            val errorKey = e.message.takeIf { message -> !message.isNullOrBlank() } ?: "outro"
            println(errorKey)
        }

    }

}