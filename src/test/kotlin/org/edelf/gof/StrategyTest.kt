package org.edelf.gof

import org.junit.Test

import org.junit.Assert.*

class StrategyTest {


    private val toInt = Context(String::toInt)
    private val toFloat = Context(String::toFloat)
    private val spliter :Context<String,List<String>> = Context { inp:String ->
        inp.split("_")
    }

    @Test
    fun operation() {
        assertEquals(1, toInt.operation("1"))
        assertEquals(1.1f, toFloat.operation("1.1"))
        assertEquals(listOf("asd","asd"), spliter.operation("asd_asd"))
    }

    @Test
    fun getStrategy() {
        assertEquals(toInt.strategy.invoke("1"),  toInt.operation("1"))
    }
}