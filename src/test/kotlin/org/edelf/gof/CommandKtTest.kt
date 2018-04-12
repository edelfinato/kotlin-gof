package org.edelf.gof

import org.junit.Test
import kotlin.test.assertEquals

internal class CommandKtTest {

    @Test
    fun executeTest() {
        execute(listOf({Command.save("asd")}, {Command.log("asd")}, fun (){ Command.send("sd")} ) )
        assertEquals(Command.operation.size, 3)
    }
}