package unitConvertor

import appendToFile
import getTime
import readNumber

enum class UnitEnum {
    Time, Height
}

object Unit {
    val unitOptions = mapOf(1 to UnitEnum.Time, 2 to UnitEnum.Height)

    private fun <T : Enum<T>> selectUnit(
        unitMap: Map<Int, T>,
        prompt: String
    ): T = readNumber(prompt).let { unitMap[it] ?: selectUnit(unitMap, prompt) }

    private fun <T : Enum<T>> performConversion(
        unit1: T,
        unit2: T,
        conversionFunction: (Double, T) -> Double
    ) {
        val value = readNumber("Enter $unit1: ")
        val ans = conversionFunction(value.toDouble(), unit2)
        val content = "$value $unit1 = $ans $unit2"
        val fileContent = "\n"+getTime() +": "+ content
        appendToFile(fileContent,"unit-convertor-history.txt")
        println(content)
    }

    fun handleTimeConversion() {

        println("Time convertor CLI")
        Time.timeOptions.forEach { (key, value) ->
            println("$key. $value")
        }
        val fromUnit = selectUnit(Time.timeOptions, "Enter the first unit you want to convert: ")
        val toUnit = selectUnit(Time.timeOptions, "$fromUnit to _____ : ")
        performConversion(fromUnit, toUnit){ value, targetUnit -> Time.convertTime(value, fromUnit, targetUnit) }
    }

    fun heightConversion() {
        println("Height convertor CLI")
        Height.heightConversionMap.forEach { (key, value) ->
            println("$key. $value")
        }
        val fromUnit = selectUnit(Height.heightConversionMap, "Enter the first unit you want to convert: ")
        val toUnit = selectUnit(Height.heightConversionMap, "$fromUnit to _____ : ")
        performConversion(fromUnit, toUnit) { value, targetUnit -> Height.convertHeight(value, fromUnit, targetUnit) }
    }
}
