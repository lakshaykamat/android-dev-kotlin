import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun getTime():String{
    val currentTime = LocalTime.now()
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    val formattedTime = currentTime.format(formatter)
    return formattedTime
}