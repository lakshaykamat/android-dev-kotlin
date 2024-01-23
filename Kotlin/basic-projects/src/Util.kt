import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

fun getTime():String{
    val currentTime = LocalTime.now()
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    val formattedTime = currentTime.format(formatter)
    return formattedTime
}
fun generateUniqueIDWithSuffix(suffix: String): String {
    val uniqueID = UUID.randomUUID().toString()
    return "$uniqueID-$suffix"
}