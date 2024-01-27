import java.io.BufferedWriter
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

object File {
    fun appendToFile(content: String, fileName: String) {
        // Use PrintWriter with BufferedWriter for better performance
        BufferedWriter(FileWriter(fileName, true)).use { writer ->
            writer.appendLine(content)
        }
    }
}