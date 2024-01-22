package unitConvertor

enum class TimeUnit {
    Millisecond, Seconds, Minutes, Hours, Days, Weeks
}

object Time {
    val timeOptions = mapOf(
        1 to TimeUnit.Millisecond,
        2 to TimeUnit.Seconds,
        3 to TimeUnit.Minutes,
        4 to TimeUnit.Hours,
        5 to TimeUnit.Days,
        6 to TimeUnit.Weeks
    )

    fun <T : Number> convertTime(value: T, fromUnit: TimeUnit, toUnit: TimeUnit): Double {
        val doubleValue = value.toDouble()
        return when (fromUnit) {
            TimeUnit.Millisecond -> convertMilliseconds(doubleValue, toUnit)
            TimeUnit.Seconds -> convertSeconds(doubleValue, toUnit)
            TimeUnit.Minutes -> convertMinutes(doubleValue, toUnit)
            TimeUnit.Hours -> convertHours(doubleValue, toUnit)
            TimeUnit.Days -> convertDays(doubleValue, toUnit)
            TimeUnit.Weeks -> convertWeeks(doubleValue, toUnit)
        }
    }

    private fun <T:Number>convertMilliseconds(milliseconds: T, targetUnit: TimeUnit): Double {
        return when (targetUnit) {
            TimeUnit.Seconds -> milliseconds.toDouble() / 1000.0
            TimeUnit.Minutes -> milliseconds.toDouble()  / (60 * 1000.0)
            TimeUnit.Hours -> milliseconds.toDouble()  / (60 * 60 * 1000.0)
            TimeUnit.Days -> milliseconds.toDouble()  / (24 * 60 * 60 * 1000.0)
            TimeUnit.Weeks -> milliseconds.toDouble()  / (7 * 24 * 60 * 60 * 1000.0)
            TimeUnit.Millisecond -> milliseconds.toDouble()
        }
    }

    private fun <T:Number> convertSeconds(seconds: T, targetUnit: TimeUnit): Double {
        return when (targetUnit) {
            TimeUnit.Millisecond -> seconds.toDouble() * 1000.0
            TimeUnit.Minutes -> seconds.toDouble() / 60.0
            TimeUnit.Hours -> seconds.toDouble() / 3600.0
            TimeUnit.Days -> seconds.toDouble() / (24 * 3600.0)
            TimeUnit.Weeks -> seconds.toDouble() / (7 * 24 * 3600.0)
            TimeUnit.Seconds -> seconds.toDouble()
        }
    }

    private fun <T:Number>convertMinutes(minutes: T, targetUnit: TimeUnit): Double {
        return when (targetUnit) {
            TimeUnit.Millisecond -> minutes.toDouble() * 60 * 1000.0
            TimeUnit.Seconds -> minutes.toDouble() * 60.0
            TimeUnit.Hours -> minutes.toDouble() / 60.0
            TimeUnit.Days -> minutes.toDouble() / (24 * 60.0)
            TimeUnit.Weeks -> minutes.toDouble() / (7 * 24 * 60.0)
            TimeUnit.Minutes -> minutes.toDouble()
        }
    }

    private fun <T:Number>convertHours(hours: T, targetUnit: TimeUnit): Double {
        return when (targetUnit) {
            TimeUnit.Millisecond -> hours.toDouble() * 60 * 60 * 1000.0
            TimeUnit.Seconds -> hours.toDouble() * 3600.0
            TimeUnit.Minutes -> hours.toDouble() * 60.0
            TimeUnit.Days -> hours.toDouble() / 24.0
            TimeUnit.Weeks -> hours.toDouble() / (7 * 24.0)
            TimeUnit.Hours -> hours.toDouble()
        }
    }

    private fun <T:Number>convertDays(days: T, targetUnit: TimeUnit): Double {
        return when (targetUnit) {
            TimeUnit.Millisecond -> days.toDouble() * 24 * 60 * 60 * 1000.0
            TimeUnit.Seconds -> days.toDouble() * 24 * 3600.0
            TimeUnit.Minutes -> days.toDouble() * 24 * 60.0
            TimeUnit.Hours -> days.toDouble() * 24.0
            TimeUnit.Weeks -> days.toDouble() / 7.0
            TimeUnit.Days -> days.toDouble()
        }
    }

    private fun <T:Number>convertWeeks(weeks: T, targetUnit: TimeUnit): Double {
        return when (targetUnit) {
            TimeUnit.Millisecond -> weeks.toDouble() * 7 * 24 * 60 * 60 * 1000.0
            TimeUnit.Seconds -> weeks.toDouble()  * 7 * 24 * 3600.0
            TimeUnit.Minutes -> weeks.toDouble()  * 7 * 24 * 60.0
            TimeUnit.Hours -> weeks.toDouble()  * 7 * 24.0
            TimeUnit.Days -> weeks.toDouble()  * 7.0
            TimeUnit.Weeks -> weeks.toDouble()
        }
    }
}