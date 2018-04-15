package org.edelf.gof

import org.junit.Test

import org.junit.Assert.*

class IntepreterKtTest {

    @Test
    fun main() {
        val expression = "7 3 - 2 1 + *"
        assertEquals(12, evaluate(expression))
    }
}