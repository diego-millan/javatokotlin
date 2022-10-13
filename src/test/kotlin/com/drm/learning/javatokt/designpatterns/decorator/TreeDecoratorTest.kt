package com.drm.learning.javatokt.designpatterns.decorator

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TreeDecoratorTest {

    @Test
    fun christmasTreeWithBubbleLights() {

        val expectedResult = "Christmas Tree with Bubble Lights"

        val christmasTree = BubbleLights(PineChristmasTree())
        val decoratedChristmasTree = christmasTree.decorate()

        Assertions.assertEquals(expectedResult, decoratedChristmasTree)
    }
}