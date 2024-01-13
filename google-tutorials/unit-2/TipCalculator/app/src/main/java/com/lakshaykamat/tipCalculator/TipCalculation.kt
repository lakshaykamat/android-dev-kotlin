package com.lakshaykamat.tipCalculator

import kotlin.math.ceil

class TipCalculation {
    fun calculateFinalAmount(amount: Double, tipAmount: Double, roundUp: Boolean): Double {
        return if (roundUp) amount + ceil(tipAmount) else amount + tipAmount
    }

    fun calculateTip(amount: Double, tipPercentage: Double): Double {
        return amount * (tipPercentage / 100)
    }
    fun limitDecimalDigits(value: Double, decimalDigits: Int): String {
        return String.format("%.${decimalDigits}f", value)
    }
}