import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun getTime(): String {
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    return currentDateTime.format(formatter)
}
fun generateUniqueIDWithSuffix(suffix: String): String {
    val uniqueID = UUID.randomUUID().toString()
    return "$uniqueID-$suffix"
}