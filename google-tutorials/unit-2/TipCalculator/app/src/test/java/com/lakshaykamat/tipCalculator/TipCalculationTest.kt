package com.lakshaykamat.tipCalculator

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TipCalculationTest {
    @Test
    fun calculateTip_20PercentNoRoundup() {
        val tp = TipCalculation()
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = 2
        val actualTip = tp.calculateTip(amount,tipPercent).toInt()
        assertEquals(expectedTip, actualTip)
    }
    @Test
    fun calculateTip_22PercentNoRoundup() {
        val tp = TipCalculation()
        val amount = 10900.00
        val tipPercent = 22.00
        val expectedTip = 2398
        val actualTip = tp.calculateTip(amount,tipPercent).toInt()
        assertEquals(expectedTip, actualTip)
    }
}