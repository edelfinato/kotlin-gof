package org.edelf.gof

import org.junit.Test

import org.junit.Assert.*

class TemplateTest {

    @Test
    fun execute() {
        val template = Template()
        val list = ArrayList<String>()
        template.execute {
            list.add(it.getEmploy())
            list.add(it.getUser())
            ""
        }
        template.execute {
            list.add(it.getEmploy())
            ""
        }
        println(list)
        assertEquals(2, Resource.counterDispose)
    }
}