import java.io.BufferedWriter
import java.io.FileWriter

fun appendToFile(content:String,fileName:String) {

    // Use PrintWriter with BufferedWriter for better performance
    BufferedWriter(FileWriter(fileName, true)).use { writer ->
        writer.appendLine(content)
    }
}