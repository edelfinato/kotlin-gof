package org.edelf.gof


class Command{
    companion object {
        var operation:ArrayList<String> =ArrayList()
        fun log(message: String) {
            operation.add("log $message")
        }

        fun save(message: String) {
            operation.add("save $message")
        }

        fun send(message: String) {
            operation.add("send $message")
        }
    }
}


fun execute(funs: List<() -> Unit>) {
    funs.forEach { it.invoke() }
}
