package contactBook

import generateUniqueIDWithSuffix
import java.io.File

data class ContactModel(val id: Int, val name: String, val number: String, val bio: String)

class Contact(private val contactModel: ContactModel) {
    val getName: String
        get() = contactModel.name

    init {
        val fileContent = """
            Id: ${contactModel.id}
            Name: ${contactModel.name}
            Number: ${contactModel.number}
            Bio: ${contactModel.bio}
        """.trimIndent()

        val contactFilePath = "${folderPath}${File.separator}${generateUniqueIDWithSuffix(contactModel.name)}.txt"
        File(contactFilePath).writeText(fileContent)
    }

    companion object {
        private const val contactFolderName: String = "your-contacts"
        val folderPath: String =
            "C:${File.separator}Users${File.separator}laksh${File.separator}Documents${File.separator}android${File.separator}kotlin${File.separator}basic-projects${File.separator}$contactFolderName"

        fun displayContactInfo(contactModel: ContactModel) {
            println("Id: ${contactModel.id}")
            println("Name: ${contactModel.name}")
            println("Number: ${contactModel.number}")
            println("Bio: ${contactModel.bio}")
        }

        fun readContacts(): List<ContactModel> {
            val contactList = mutableListOf<ContactModel>()

            File(folderPath).listFiles()?.forEach { contactFile ->
                try {
                    val lines = contactFile.useLines { it.toList() }
                    val id = lines.find { it.startsWith("Id:") }?.substringAfter("Id:")?.trim() ?: ""
                    val name = lines.find { it.startsWith("Name:") }?.substringAfter("Name:")?.trim() ?: ""
                    val number = lines.find { it.startsWith("Number:") }?.substringAfter("Number:")?.trim() ?: ""
                    val bio = lines.find { it.startsWith("Bio:") }?.substringAfter("Bio:")?.trim() ?: ""
                    val contact = ContactModel(id.toInt(), name, number, bio)
                    contactList.add(contact)
                } catch (e: Exception) {
                    println("Error reading contact file: ${contactFile.name}. ${e.message}")
                }
            }

            return contactList.sortedBy { it.id }
        }
    }
}