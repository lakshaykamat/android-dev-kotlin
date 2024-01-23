package contactBook

import readNumber
import java.io.File

enum class MainMenuOptions { YourContacts, AddNewContact }

fun main() {
    println("Contacts CLI Tool")
    File(Contact.folderPath).mkdirs()

    val mainMenuMap = mapOf(
        1 to MainMenuOptions.YourContacts,
        2 to MainMenuOptions.AddNewContact
    )
    val userChoice = readOption("Enter Option:", mainMenuMap)
    val contacts = Contact.readContacts()

    when (userChoice) {
        MainMenuOptions.YourContacts -> {
            println("You have currently ${contacts.size} contacts.")
            contacts.forEach {contact ->
                println("${contact.id}. ${contact.name}")
            }
            val number = readNumber()
            contacts.find { it.id == number }?.let { Contact.displayContactInfo(it) }
        }

        MainMenuOptions.AddNewContact -> {
            val name = readContactName("Enter name: ")
            val number = readContactNumber("Enter number: ")
            val bio = readContactName("Enter bio: ")
            Contact(ContactModel(contacts.size + 1, name, number, bio))
            println("$name Saved to contact list.")
        }
    }
}

fun showMapItems(map: Map<Int, MainMenuOptions>) {
    map.forEach { (key, value) ->
        println("$key. $value")
    }
}
