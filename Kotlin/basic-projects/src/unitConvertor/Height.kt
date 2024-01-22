package unitConvertor

enum class HeightUnit {
    NauticalMile, Inch, Foot, Yard, Mile, Nanometre, Micrometres, Millimetre, Centimeter, Meter, Kilometer
}

object Height {
    val heightConversionMap = mapOf(
        1 to HeightUnit.NauticalMile,
        2 to HeightUnit.Inch,
        3 to HeightUnit.Foot,
        4 to HeightUnit.Yard,
        5 to HeightUnit.Mile,
        6 to HeightUnit.Nanometre,
        7 to HeightUnit.Micrometres,
        8 to HeightUnit.Millimetre,
        9 to HeightUnit.Centimeter,
        10 to HeightUnit.Meter,
        11 to HeightUnit.Kilometer
    )

    fun <T : Number> convertHeight(value: T, fromUnit: HeightUnit, toUnit: HeightUnit): Double {
        if (fromUnit == toUnit) {
            return value.toDouble() // No conversion needed
        }

        return when (fromUnit) {
            HeightUnit.NauticalMile -> convertFromNauticalMile(value, toUnit)
            HeightUnit.Inch -> convertFromInch(value, toUnit)
            HeightUnit.Foot -> convertFromFoot(value, toUnit)
            HeightUnit.Yard -> convertFromYard(value, toUnit)
            HeightUnit.Mile -> convertFromMile(value, toUnit)
            HeightUnit.Nanometre -> convertFromNanometre(value, toUnit)
            HeightUnit.Micrometres -> convertFromMicrometres(value, toUnit)
            HeightUnit.Millimetre -> convertFromMillimetre(value, toUnit)
            HeightUnit.Centimeter -> convertFromCentimeter(value, toUnit)
            HeightUnit.Meter -> convertFromMeter(value, toUnit)
            HeightUnit.Kilometer -> convertFromKilometer(value, toUnit)
        }
    }

    private fun <T : Number> convertFromNauticalMile(value: T, toUnit: HeightUnit): Double {
        return when (toUnit) {
            HeightUnit.Inch -> value.toDouble() * 72913.3858
            HeightUnit.Foot -> value.toDouble() * 6076.11549
            HeightUnit.Yard -> value.toDouble() * 2025.37183
            HeightUnit.Mile -> value.toDouble() / 1.15078
            HeightUnit.Nanometre -> value.toDouble() * 1852000000
            HeightUnit.Micrometres -> value.toDouble() * 1852000000000
            HeightUnit.Millimetre -> value.toDouble() * 1852000000
            HeightUnit.Centimeter -> value.toDouble() * 185200000
            HeightUnit.Meter -> value.toDouble() * 1852
            HeightUnit.Kilometer -> value.toDouble() * 1.852
            HeightUnit.NauticalMile -> value.toDouble()
        }
    }

    private fun <T : Number> convertFromInch(value: T, toUnit: HeightUnit): Double {
        return when (toUnit) {
            HeightUnit.NauticalMile -> value.toDouble() / 72913.3858
            HeightUnit.Foot -> value.toDouble() / 12.0
            HeightUnit.Yard -> value.toDouble() / 36.0
            HeightUnit.Mile -> value.toDouble() / 63360.0
            HeightUnit.Nanometre -> value.toDouble() * 25400000
            HeightUnit.Micrometres -> value.toDouble() * 25400
            HeightUnit.Millimetre -> value.toDouble() * 25.4
            HeightUnit.Centimeter -> value.toDouble() * 2.54
            HeightUnit.Meter -> value.toDouble() * 0.0254
            HeightUnit.Kilometer -> value.toDouble() * 0.0000254
            HeightUnit.Inch -> value.toDouble()
        }
    }

    private fun <T : Number> convertFromFoot(value: T, toUnit: HeightUnit): Double {
        return when (toUnit) {
            HeightUnit.NauticalMile -> value.toDouble() / 6076.11549
            HeightUnit.Inch -> value.toDouble() * 12.0
            HeightUnit.Yard -> value.toDouble() / 3.0
            HeightUnit.Mile -> value.toDouble() / 5280.0
            HeightUnit.Nanometre -> value.toDouble() * 304800000
            HeightUnit.Micrometres -> value.toDouble() * 304800
            HeightUnit.Millimetre -> value.toDouble() * 304.8
            HeightUnit.Centimeter -> value.toDouble() * 30.48
            HeightUnit.Meter -> value.toDouble() * 0.3048
            HeightUnit.Kilometer -> value.toDouble() * 0.0003048
            HeightUnit.Foot -> value.toDouble()
        }
    }

    private fun <T : Number> convertFromYard(value: T, toUnit: HeightUnit): Double {
        return when (toUnit) {
            HeightUnit.NauticalMile -> value.toDouble() / 2025.37183
            HeightUnit.Inch -> value.toDouble() * 36.0
            HeightUnit.Foot -> value.toDouble() * 3.0
            HeightUnit.Mile -> value.toDouble() / 1760.0
            HeightUnit.Nanometre -> value.toDouble() * 914400000
            HeightUnit.Micrometres -> value.toDouble() * 914400
            HeightUnit.Millimetre -> value.toDouble() * 914.4
            HeightUnit.Centimeter -> value.toDouble() * 91.44
            HeightUnit.Meter -> value.toDouble() * 0.9144
            HeightUnit.Kilometer -> value.toDouble() * 0.0009144
            HeightUnit.Yard -> value.toDouble()
        }
    }

    private fun <T : Number> convertFromMile(value: T, toUnit: HeightUnit): Double {
        return when (toUnit) {
            HeightUnit.NauticalMile -> value.toDouble() * 1.15078
            HeightUnit.Inch -> value.toDouble() * 63360.0
            HeightUnit.Foot -> value.toDouble() * 5280.0
            HeightUnit.Yard -> value.toDouble() * 1760.0
            HeightUnit.Nanometre -> value.toDouble() * 1609000000
            HeightUnit.Micrometres -> value.toDouble() * 1609000000000
            HeightUnit.Millimetre -> value.toDouble() * 1609000000
            HeightUnit.Centimeter -> value.toDouble() * 160900000
            HeightUnit.Meter -> value.toDouble() * 1609.0
            HeightUnit.Kilometer -> value.toDouble() * 1.609
            HeightUnit.Mile -> value.toDouble()
        }
    }

    private fun <T : Number> convertFromNanometre(value: T, toUnit: HeightUnit): Double {
        return when (toUnit) {
            HeightUnit.NauticalMile -> value.toDouble() / 1852000000
            HeightUnit.Inch -> value.toDouble() / 25400000
            HeightUnit.Foot -> value.toDouble() / 304800000
            HeightUnit.Yard -> value.toDouble() / 914400000
            HeightUnit.Mile -> value.toDouble() / 1609000000
            HeightUnit.Micrometres -> value.toDouble() / 1000.0
            HeightUnit.Millimetre -> value.toDouble() / 1000000.0
            HeightUnit.Centimeter -> value.toDouble() / 10000000.0
            HeightUnit.Meter -> value.toDouble() / 1000000000.0
            HeightUnit.Kilometer -> value.toDouble() / 1000000000000.0
            HeightUnit.Nanometre -> value.toDouble()
        }
    }

    private fun <T : Number> convertFromMicrometres(value: T, toUnit: HeightUnit): Double {
        return when (toUnit) {
            HeightUnit.NauticalMile -> value.toDouble() / 1852000000000
            HeightUnit.Inch -> value.toDouble() / 25400
            HeightUnit.Foot -> value.toDouble() / 304800
            HeightUnit.Yard -> value.toDouble() / 914400
            HeightUnit.Mile -> value.toDouble() / 1609000000000
            HeightUnit.Nanometre -> value.toDouble() * 1000.0
            HeightUnit.Millimetre -> value.toDouble() / 1000.0
            HeightUnit.Centimeter -> value.toDouble() / 10000.0
            HeightUnit.Meter -> value.toDouble() / 1000000.0
            HeightUnit.Kilometer -> value.toDouble() / 1000000000.0
            HeightUnit.Micrometres -> value.toDouble()
        }
    }

    private fun <T : Number> convertFromMillimetre(value: T, toUnit: HeightUnit): Double {
        return when (toUnit) {
            HeightUnit.NauticalMile -> value.toDouble() / 1852000000
            HeightUnit.Inch -> value.toDouble() / 25.4
            HeightUnit.Foot -> value.toDouble() / 304.8
            HeightUnit.Yard -> value.toDouble() / 914.4
            HeightUnit.Mile -> value.toDouble() / 1609000000
            HeightUnit.Nanometre -> value.toDouble() * 1000000.0
            HeightUnit.Micrometres -> value.toDouble() * 1000.0
            HeightUnit.Centimeter -> value.toDouble() / 10.0
            HeightUnit.Meter -> value.toDouble() / 1000.0
            HeightUnit.Kilometer -> value.toDouble() / 1000000.0
            HeightUnit.Millimetre -> value.toDouble()
        }
    }

    private fun <T : Number> convertFromCentimeter(value: T, toUnit: HeightUnit): Double {
        return when (toUnit) {
            HeightUnit.NauticalMile -> value.toDouble() / 185200000
            HeightUnit.Inch -> value.toDouble() / 2.54
            HeightUnit.Foot -> value.toDouble() / 30.48
            HeightUnit.Yard -> value.toDouble() / 91.44
            HeightUnit.Mile -> value.toDouble() / 160900000
            HeightUnit.Nanometre -> value.toDouble() * 10000000.0
            HeightUnit.Micrometres -> value.toDouble() * 10000.0
            HeightUnit.Millimetre -> value.toDouble() * 10.0
            HeightUnit.Meter -> value.toDouble() / 100.0
            HeightUnit.Kilometer -> value.toDouble() / 100000.0
            HeightUnit.Centimeter -> value.toDouble()
        }
    }

    private fun <T : Number> convertFromMeter(value: T, toUnit: HeightUnit): Double {
        return when (toUnit) {
            HeightUnit.NauticalMile -> value.toDouble() / 1852
            HeightUnit.Inch -> value.toDouble() / 0.0254
            HeightUnit.Foot -> value.toDouble() / 0.3048
            HeightUnit.Yard -> value.toDouble() / 0.9144
            HeightUnit.Mile -> value.toDouble() / 1609.0
            HeightUnit.Nanometre -> value.toDouble() * 1000000000.0
            HeightUnit.Micrometres -> value.toDouble() * 1000000.0
            HeightUnit.Millimetre -> value.toDouble() * 1000.0
            HeightUnit.Centimeter -> value.toDouble() * 100.0
            HeightUnit.Kilometer -> value.toDouble() / 1000.0
            HeightUnit.Meter -> value.toDouble()
        }
    }

    private fun <T : Number> convertFromKilometer(value: T, toUnit: HeightUnit): Double {
        return when (toUnit) {
            HeightUnit.NauticalMile -> value.toDouble() / 1.852
            HeightUnit.Inch -> value.toDouble() / 0.0000254
            HeightUnit.Foot -> value.toDouble() / 0.0003048
            HeightUnit.Yard -> value.toDouble() / 0.0009144
            HeightUnit.Mile -> value.toDouble() / 1.609
            HeightUnit.Nanometre -> value.toDouble() * 1000000000000.0
            HeightUnit.Micrometres -> value.toDouble() * 1000000000.0
            HeightUnit.Millimetre -> value.toDouble() * 1000000.0
            HeightUnit.Centimeter -> value.toDouble() * 100000.0
            HeightUnit.Meter -> value.toDouble() * 1000.0
            HeightUnit.Kilometer -> value.toDouble()
        }
    }
}

