package org.edelf.gof

import org.junit.Test

import org.junit.Assert.*

class ObservableTest {
    var counter = 0;

    @Test
    fun sendEvent() {
        val observable = Observable()
        observable.register("1", { input -> counter = counter + input as Int })
        observable.register("2", { input -> counter = counter * input as Int})
        observable.sendEvent(3)
        assertEquals(9,counter)
    }
}