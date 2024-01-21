package unitConvertor

import readInt

enum class UnitEnum{
    Time,
    Height
}

object Unit {
    val unitOptions = mapOf<Int,UnitEnum>(
        1 to UnitEnum.Time,
        2 to UnitEnum.Height
    )
    private fun showResult(value: Int, firstParameter: TimeEnum, ans: Double, secondParameter: TimeEnum) {
        val msg = "$value $firstParameter = $ans $secondParameter"
        println(msg)
    }

    fun handleTimeConversion() {
        var timeUnit1: TimeEnum? = null
        var timeUnit2: TimeEnum? = null

        // Select the initial and target time units
        while (timeUnit1 == null || timeUnit2 == null || timeUnit1 == timeUnit2) {
            println("Time converter CLI")
            Time.timeOptions.forEach { (key, value) ->
                println("$key. $value")
            }
            val firstParameter = readInt("Enter the first unit you want to convert: ")
            timeUnit1 = Time.timeOptions[firstParameter]

            val secondParameter = readInt("$timeUnit1 to _____ : ")
            timeUnit2 = Time.timeOptions[secondParameter]
        }

        // Perform the conversion based on the selected time units
        val value = readInt("Enter $timeUnit1: ")
        val ans = when (timeUnit1) {
            TimeEnum.Millisecond -> Time.convertMilliseconds(value.toDouble(), timeUnit2)
            TimeEnum.Seconds -> Time.convertSeconds(value.toDouble(), timeUnit2)
            TimeEnum.Minutes -> Time.convertMinutes(value.toDouble(), timeUnit2)
            TimeEnum.Hours -> Time.convertHours(value.toDouble(), timeUnit2)
            TimeEnum.Days -> Time.convertDays(value.toDouble(), timeUnit2)
            TimeEnum.Weeks -> Time.convertWeeks(value.toDouble(), timeUnit2)
        }

        showResult(value, timeUnit1, ans, timeUnit2)
    }
}