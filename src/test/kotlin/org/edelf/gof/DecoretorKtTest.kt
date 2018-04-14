package org.edelf.gof

import org.junit.Test
import kotlin.test.assertEquals


class DecoretorKtTest {

    @Test
    fun compose() {
        val salaryK = defaultSalaryCalculator
                .compose(Taxes.Companion::country)
                .compose(Taxes.Companion::regional)
                .compose(Taxes.Companion::healtyInsurance)(30_000.0)
        val salaryJ = DefaultSalaryCalculator()
                .compose(Taxes.Companion::country)
                .compose(Taxes.Companion::regional)
                .compose(Taxes.Companion::healtyInsurance).applyAsDouble(30_000.0)
        assertEquals(salaryJ,salaryK)
    }

}