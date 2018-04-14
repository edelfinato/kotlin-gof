package org.edelf.gof

import org.junit.Test

import org.junit.Assert.*

class ChianOfResponsabilityKtTest {

    @Test
    fun javastyle() {
        val file = File.VideoFile("sono un bel video")
        val firstOrNull = funs.map { it(file) }.filterNotNull().firstOrNull()
        println(file)
        assertEquals(file.content,firstOrNull)
    }

}