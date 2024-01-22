package unitConvertor

import readNumber

fun main() {
    var selectedUnit: UnitEnum? = null

    // Select the main unit to convert
    while (selectedUnit == null) {
        println("Unit convertor CLI")
        Unit.unitOptions.forEach { (key, value) ->
            println("$key. $value")
        }
        val input = readNumber("Enter the number corresponding to the unit you want to convert: ")
        selectedUnit = Unit.unitOptions[input]
    }

    when (selectedUnit) {
        UnitEnum.Time -> Unit.handleTimeConversion()
        UnitEnum.Height -> Unit.heightConversion()
    }
}