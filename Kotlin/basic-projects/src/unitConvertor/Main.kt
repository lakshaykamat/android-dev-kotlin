package unitConvertor

import readInt

fun main() {
    var selectedUnit: UnitEnum? = null

    // Select the main unit to convert
    while (selectedUnit == null) {
        println("Unit convertor CLI")
        Unit.unitOptions.map { (key, value) ->
            println("$key. $value")
        }
        val input =
            readInt("Enter the number corresponding to the unit you want to convert: ") //ask user what to convert
        selectedUnit = Unit.unitOptions[input]
    }

    when (selectedUnit) {
        UnitEnum.Time -> Unit.handleTimeConversion()
        UnitEnum.Height -> TODO()
    }
}

