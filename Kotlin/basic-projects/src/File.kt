import java.io.BufferedWriter
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

object File {
    fun isDirectoryEmpty(directoryPath: String): Boolean {
        val path = Paths.get(directoryPath)
        return Files.list(path).use { it.findAny().isEmpty }
    }

    fun appendToFile(content: String, fileName: String) {

        // Use PrintWriter with BufferedWriter for better performance
        BufferedWriter(FileWriter(fileName, true)).use { writer ->
            writer.appendLine(content)
        }
    }

    fun countItemsInDirectory(directoryPath: String): Int {
        val path = Paths.get(directoryPath)
        return Files.list(path).count().toInt()
    }

    fun createFolder(folderName: String, path: String):Boolean {
        val folderPath = Paths.get(path + "\\" + folderName)
        try {
            Files.createDirectories(folderPath)
            return true
        } catch (e: Exception) {
           return false
        }
    }

    fun createFileWithContent(filePath: String, content: String) :Boolean{
        val path: Path = Paths.get(filePath)

        try {
            // Create the file
            Files.createFile(path)

            // Write content to the file
            BufferedWriter(FileWriter(filePath)).use { writer ->
                writer.write(content)
            }

           return true
        } catch (e: Exception) {
            return false
        }
    }
    fun readAllFilesInDirectory(directoryPath: String): MutableList<Path>? {
        return Files.walk(Paths.get(directoryPath))
            .filter { Files.isRegularFile(it) }
            .toList()
    }
    fun readDirectoryContents(directoryPath: String) {
        val path: Path = Paths.get(directoryPath)

        try {
            val directoryStream = Files.newDirectoryStream(path)

            for (file in directoryStream) {
                println(file.fileName)
            }

            directoryStream.close()
        } catch (e: Exception) {
            println("Error reading directory contents: ${e.message}")
        }
    }
    fun readFileContent(filePath: String): String? {
        val path = Paths.get(filePath)

        return try {
            String(Files.readAllBytes(path))
        } catch (e: Exception) {
            println("Error reading file content: ${e.message}")
            null
        }
    }
}