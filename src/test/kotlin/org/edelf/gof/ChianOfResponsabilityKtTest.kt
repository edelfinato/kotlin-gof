package org.edelf.gof

import org.junit.Test

import org.junit.Assert.*

class ChianOfResponsabilityKtTest {

    @Test
    fun javastyle() {
        val file = File.VideoFile("sono un bel video")
        println("responsability with stream map $file")
        var firstOrNull = funs.stream().map { it(file) }.filter{it != null}.findFirst().get()
        assertEquals(file.content,firstOrNull)
    }


    @Test
    fun kotlinstyle() {
        val file = File.VideoFile("sono un bel video")
        println("responsability with kotlin map $file")
        var firstOrNull = funs.map { it(file) }.filterNotNull().first()
        assertEquals(file.content,firstOrNull)
    }

}