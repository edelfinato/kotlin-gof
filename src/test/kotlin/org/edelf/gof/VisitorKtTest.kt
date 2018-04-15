package org.edelf.gof

import org.junit.Test
import kotlin.test.assertEquals


class VisitorKtTest {

    val figures = listOf<Figure>(Circle(4.0), Square(5.0), Rectangle(6.0, 7.0))

    @Test
    fun area() {
        val fold = figures.map { it.area() }.fold(0.0, { a, b -> a + b })
        assertEquals(117.26548245743669,fold)
    }

    @Test
    fun perimeter() {
        val fold = figures.map { it.perimeter() }.fold(0.0, { a, b -> a + b })
        assertEquals(71.13274122871834,fold)
        assertEquals(0.0, listOf<Figure>().map { it.perimeter() }.fold(0.0, { a, b -> a + b }))
    }
}