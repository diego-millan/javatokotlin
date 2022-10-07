package com.drm.learning.javatokt.types

import com.drm.learning.javatokt.domain.Android
import com.drm.learning.javatokt.domain.Iphone
import com.drm.learning.javatokt.domain.Smartphone
import com.drm.learning.javatokt.domain.findByType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ReifiedTest {

    @Test
    fun `when use reified to list by type, should filter by type properly`() {
        val smartphones = mutableListOf<Smartphone>(Android(), Iphone())

        val android = smartphones.findByType<Android>()
        Assertions.assertNotNull(android)
    }
}