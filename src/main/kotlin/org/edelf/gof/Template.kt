package org.edelf.gof

import java.util.*

class Resource {
    constructor() {
        println("create Resouce")
    }

    fun getUser(): String {
        throwEx()
        return "user"
    }

    fun getEmploy(): String {
        throwEx()
        return "employ"
    }

    private fun throwEx() {
        val nextInt = Random().nextInt(3)
        if (nextInt == 0) {
            throw RuntimeException("random ex")
        }
    }

    fun dispose() {
        println("dispose")
        Companion.counterDispose++
    }

    companion object {
        var counterDispose = 0
    }
}


class Template {
    fun execute(consumer: (Resource) -> String){
        val resource = Resource()
        try {
            consumer(resource)
        } catch (ex :RuntimeException) {
            println("a runtimeEx happened " + ex)
        } finally {
            resource.dispose()
        }
    }
}