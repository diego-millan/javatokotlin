package com.drm.learning.javatokt.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Given a Quantity validation")
class QuantityValidationUtilTest {
    @Test
    fun `when try to get quantity and it have dots, then should remove decimal or thousand dots or refuse if its float number`() {
        val validQuantity1 = QuantityValidationUtil.sanitizeStringToLong("2,000,000")
        val validQuantity2 = QuantityValidationUtil.sanitizeStringToLong("2,000,000.00")
        val validQuantity3 = QuantityValidationUtil.sanitizeStringToLong("2,000,000,00")
        val validQuantity4 = QuantityValidationUtil.sanitizeStringToLong("100,000")
        val validQuantity5 = QuantityValidationUtil.sanitizeStringToLong("2,00")

        val invalidQuantity1 = QuantityValidationUtil.sanitizeStringToLong("2,01")
        val invalidQuantity2 = QuantityValidationUtil.sanitizeStringToLong("2,00,000,00")
        val invalidQuantity3 = QuantityValidationUtil.sanitizeStringToLong("2.1")

        assertEquals(validQuantity1, 2000000L)
        assertEquals(validQuantity2, 2000000L)
        assertEquals(validQuantity3, 2000000L)
        assertEquals(validQuantity4, 100000L)
        assertEquals(validQuantity5, 2L)

        assertNull(invalidQuantity1)
        assertNull(invalidQuantity2)
        assertNull(invalidQuantity3)
    }
}