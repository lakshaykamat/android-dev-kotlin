package com.lakshaykamat.timeConvertor

import java.math.BigDecimal
import java.math.RoundingMode

object Time {
    fun performConversion(fromUnit: TimeUnits, toUnit: TimeUnits, value: Double): Double {
        val result = when (fromUnit) {
            TimeUnits.Nanosecond -> convertFromNanoseconds(toUnit, value)
            TimeUnits.Microsecond -> convertFromMicroseconds(toUnit, value)
            TimeUnits.Millisecond -> convertFromMilliseconds(toUnit, value)
            TimeUnits.Second -> convertFromSeconds(toUnit, value)
            TimeUnits.Minute -> convertFromMinutes(toUnit, value)
            TimeUnits.Hour -> convertFromHours(toUnit, value)
            TimeUnits.Day -> convertFromDays(toUnit, value)
            TimeUnits.Week -> convertFromWeeks(toUnit, value)
            TimeUnits.Month -> convertFromMonths(toUnit, value)
            TimeUnits.Year -> convertFromYears(toUnit, value)
            TimeUnits.Decade -> convertFromDecades(toUnit, value)
            TimeUnits.Century -> convertFromCenturies(toUnit, value)
        }
        return BigDecimal(result).setScale(2, RoundingMode.HALF_UP).toDouble()
    }

    private fun convertFromNanoseconds(toUnit: TimeUnits, value: Double): Double {
        return when (toUnit) {
            TimeUnits.Nanosecond -> value
            TimeUnits.Microsecond -> value / 1000.0
            TimeUnits.Millisecond -> value / 1_000_000.0
            TimeUnits.Second -> value / 1_000_000_000.0
            TimeUnits.Minute -> value / 60_000_000_000.0
            TimeUnits.Hour -> value / 3_600_000_000_000.0
            TimeUnits.Day -> value / 86_400_000_000_000.0
            TimeUnits.Week -> value / 604_800_000_000_000.0
            TimeUnits.Month -> value / (2.628e+15) // Assuming an average month length
            TimeUnits.Year -> value / (3.154e+16) // Assuming an average year length
            TimeUnits.Decade -> value / (3.154e+17)
            TimeUnits.Century -> value / (3.154e+18)
        }
    }

    private fun convertFromMicroseconds(toUnit: TimeUnits, value: Double): Double {
        return convertFromNanoseconds(toUnit, value * 1000.0)
    }

    private fun convertFromMilliseconds(toUnit: TimeUnits, value: Double): Double {
        return convertFromNanoseconds(toUnit, value * 1_000_000.0)
    }

    private fun convertFromSeconds(toUnit: TimeUnits, value: Double): Double {
        return convertFromNanoseconds(toUnit, value * 1_000_000_000.0)
    }

    private fun convertFromMinutes(toUnit: TimeUnits, value: Double): Double {
        return convertFromNanoseconds(toUnit, value * 60_000_000_000.0)
    }

    private fun convertFromHours(toUnit: TimeUnits, value: Double): Double {
        return convertFromNanoseconds(toUnit, value * 3_600_000_000_000.0)
    }

    private fun convertFromDays(toUnit: TimeUnits, value: Double): Double {
        return convertFromNanoseconds(toUnit, value * 86_400_000_000_000.0)
    }

    private fun convertFromWeeks(toUnit: TimeUnits, value: Double): Double {
        return convertFromNanoseconds(toUnit, value * 604_800_000_000_000.0)
    }

    private fun convertFromMonths(toUnit: TimeUnits, value: Double): Double {
        return convertFromNanoseconds(toUnit, value * (2.628e+15))
    }

    private fun convertFromYears(toUnit: TimeUnits, value: Double): Double {
        return convertFromNanoseconds(toUnit, value * (3.154e+16))
    }

    private fun convertFromDecades(toUnit: TimeUnits, value: Double): Double {
        return convertFromNanoseconds(toUnit, value * (3.154e+17))
    }

    private fun convertFromCenturies(toUnit: TimeUnits, value: Double): Double {
        return convertFromNanoseconds(toUnit, value * (3.154e+18))
    }

}