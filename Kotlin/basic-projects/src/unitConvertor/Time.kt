package unitConvertor

enum class TimeEnum {
    Millisecond,
    Seconds,
    Minutes,
    Hours,
    Days,
    Weeks
}

object Time {
    val timeOptions = mapOf(
        1 to TimeEnum.Millisecond,
        2 to TimeEnum.Seconds,
        3 to TimeEnum.Minutes,
        4 to TimeEnum.Hours,
        5 to TimeEnum.Days,
        6 to TimeEnum.Weeks
    )

    fun convertMilliseconds(value: Double, targetUnit: TimeEnum): Double {
        return when (targetUnit) {
            TimeEnum.Seconds -> millisecondsToSeconds(value)
            TimeEnum.Minutes -> millisecondsToMinutes(value)
            TimeEnum.Hours -> millisecondsToHours(value)
            TimeEnum.Days -> millisecondsToDays(value)
            TimeEnum.Weeks -> millisecondsToWeeks(value)
            TimeEnum.Millisecond -> value
        }
    }

    fun convertSeconds(value: Double, targetUnit: TimeEnum): Double {
        return when (targetUnit) {
            TimeEnum.Millisecond -> secondsToMilliseconds(value)
            TimeEnum.Minutes -> secondsToMinutes(value)
            TimeEnum.Hours -> secondsToHours(value)
            TimeEnum.Days -> secondsToDays(value)
            TimeEnum.Weeks -> secondsToWeeks(value)
            TimeEnum.Seconds -> value
        }
    }

    fun convertMinutes(value: Double, targetUnit: TimeEnum): Double {
        return when (targetUnit) {
            TimeEnum.Millisecond -> minutesToMilliseconds(value)
            TimeEnum.Seconds -> minutesToSeconds(value)
            TimeEnum.Hours -> minutesToHours(value)
            TimeEnum.Days -> minutesToDays(value)
            TimeEnum.Weeks -> minutesToWeeks(value)
            TimeEnum.Minutes -> value
        }
    }

    fun convertHours(value: Double, targetUnit: TimeEnum): Double {
        return when (targetUnit) {
            TimeEnum.Millisecond -> hoursToMilliseconds(value)
            TimeEnum.Seconds -> hoursToSeconds(value)
            TimeEnum.Minutes -> hoursToMinutes(value)
            TimeEnum.Days -> hoursToDays(value)
            TimeEnum.Weeks -> hoursToWeeks(value)
            TimeEnum.Hours -> value
        }
    }

    fun convertDays(value: Double, targetUnit: TimeEnum): Double {
        return when (targetUnit) {
            TimeEnum.Millisecond -> daysToMilliseconds(value)
            TimeEnum.Seconds -> daysToSeconds(value)
            TimeEnum.Minutes -> daysToMinutes(value)
            TimeEnum.Hours -> daysToHours(value)
            TimeEnum.Weeks -> daysToWeeks(value)
            TimeEnum.Days -> value
        }
    }

    fun convertWeeks(value: Double, targetUnit: TimeEnum): Double {
        return when (targetUnit) {
            TimeEnum.Millisecond -> weeksToMilliseconds(value)
            TimeEnum.Seconds -> weeksToSeconds(value)
            TimeEnum.Minutes -> weeksToMinutes(value)
            TimeEnum.Hours -> weeksToHours(value)
            TimeEnum.Days -> weeksToDays(value)
            TimeEnum.Weeks -> value
        }
    }

    private fun millisecondsToSeconds(milliseconds: Double): Double {
        return milliseconds / 1000.0
    }

    private fun millisecondsToMinutes(milliseconds: Double): Double {
        val minutesInMillis = 60 * 1000.0 // 1 minute = 60 seconds * 1000 milliseconds
        return milliseconds / minutesInMillis
    }

    private fun millisecondsToHours(milliseconds: Double): Double {
        return milliseconds / (60 * 60 * 1000.0)
    }

    private fun millisecondsToDays(milliseconds: Double): Double {
        return milliseconds / (24 * 60 * 60 * 1000.0)
    }

    private fun millisecondsToWeeks(milliseconds: Double): Double {
        return milliseconds / (7 * 24 * 60 * 60 * 1000.0)
    }

    private fun secondsToMilliseconds(seconds: Double): Double {
        return seconds * 1000.0
    }

    private fun secondsToMinutes(seconds: Double): Double {
        return seconds / 60.0
    }

    private fun secondsToHours(seconds: Double): Double {
        return seconds / 3600.0
    }

    private fun secondsToDays(seconds: Double): Double {
        return seconds / (3600.0 * 24)
    }

    private fun secondsToWeeks(seconds: Double): Double {
        return seconds / (3600.0 * 24 * 7)
    }

    private fun minutesToMilliseconds(minutes: Double): Double {
        val minutesInMillis = minutes * 60 * 1000.0 // 1 minute = 60 seconds * 1000 milliseconds
        return minutesInMillis
    }

    private fun minutesToSeconds(minutes: Double): Double {
        return minutes * 60.0
    }

    private fun minutesToHours(minutes: Double): Double {
        return minutes / 60.0
    }

    private fun minutesToDays(minutes: Double): Double {
        return minutes / (24 * 60)
    }

    private fun minutesToWeeks(minutes: Double): Double {
        return minutes / (7 * 24 * 60)
    }

    private fun hoursToMilliseconds(hours: Double): Double {
        val hoursInMillis = hours * 60 * 60 * 1000.0 // 1 hour = 60 minutes * 60 seconds * 1000 milliseconds
        return hoursInMillis
    }

    private fun hoursToSeconds(hours: Double): Double {
        return hours * 3600.0
    }

    private fun hoursToMinutes(hours: Double): Double {
        return hours * 60.0
    }

    private fun hoursToDays(hours: Double): Double {
        return hours / 24.0
    }

    private fun hoursToWeeks(hours: Double): Double {
        return hours / (7 * 24)
    }

    private fun daysToMilliseconds(days: Double): Double {
        val daysInMillis = days * 24 * 60 * 60 * 1000.0 // 1 day = 24 hours * 60 minutes * 60 seconds * 1000 milliseconds
        return daysInMillis
    }

    private fun daysToSeconds(days: Double): Double {
        return days * 24 * 3600.0
    }

    private fun daysToMinutes(days: Double): Double {
        return days * 24 * 60.0
    }

    private fun daysToHours(days: Double): Double {
        return days * 24.0
    }

    private fun daysToWeeks(days: Double): Double {
        return days / 7.0
    }

    private fun weeksToMilliseconds(weeks: Double): Double {
        val weeksInMillis = weeks * 7 * 24 * 60 * 60 * 1000.0 // 1 week = 7 days * 24 hours * 60 minutes * 60 seconds * 1000 milliseconds
        return weeksInMillis
    }

    private fun weeksToSeconds(weeks: Double): Double {
        return weeks * 7 * 24 * 3600.0
    }

    private fun weeksToMinutes(weeks: Double): Double {
        return weeks * 7 * 24 * 60.0
    }

    private fun weeksToHours(weeks: Double): Double {
        return weeks * 7 * 24.0
    }

    private fun weeksToDays(weeks: Double): Double {
        return weeks * 7.0
    }
}
