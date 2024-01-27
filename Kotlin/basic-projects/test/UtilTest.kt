import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class UtilTest{
    @Test
    fun `getTime should return the current date and time in the expected format`() {
        val currentTimeString = getTime()

        // Define the expected format for the date and time
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

        // Parse the returned time string to LocalDateTime
        val returnedDateTime = LocalDateTime.parse(currentTimeString, formatter)

        // Calculate the difference between the current time and the parsed time
        val timeDifferenceInSeconds = ChronoUnit.SECONDS.between(returnedDateTime, LocalDateTime.now())

        // Ensure that the time difference is within an acceptable range (e.g., 1 second)
        assertTrue { timeDifferenceInSeconds < 1 }
    }
}