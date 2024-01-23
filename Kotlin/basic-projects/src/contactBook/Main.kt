package contactBook

import readNumber
import readYesNoInput
import java.io.File

enum class MainMenuOptions { YourContacts, AddNewContact }

fun main() {
    println("Contacts CLI Tool")
    File(Contact.folderPath).mkdirs()

    val mainMenuMap = mapOf(
        1 to MainMenuOptions.YourContacts,
        2 to MainMenuOptions.AddNewContact
    )
    var userChoice = readOption("Enter Option:", mainMenuMap)
    val contacts = Contact.readContacts()

    when (userChoice) {
        MainMenuOptions.YourContacts -> {
            println("You have currently ${contacts.size} contacts.")
            if(contacts.isNotEmpty()){
                contacts.forEach {contact ->
                    println("${contact.id}. ${contact.name}")
                }
                val number = readNumber()
                contacts.find { it.id == number }?.let { Contact.displayContactInfo(it) }
            }else{
                val yesOrNo = readYesNoInput("Do you want to create contact?(y/n): ")
                if(yesOrNo){
                 contactInput(contacts.size)
                }
            }

        }

        MainMenuOptions.AddNewContact -> {
            contactInput(contacts.size)
        }
    }
}

fun showMapItems(map: Map<Int, MainMenuOptions>) {
    map.forEach { (key, value) ->
        println("$key. $value")
    }
}

fun contactInput(contactSize:Int): Contact {
    val name = readContactName("Enter name: ")
    val number = readContactNumber("Enter number: ")
    val bio = readContactName("Enter bio: ")
    val contact:Contact=  Contact(ContactModel(contactSize + 1, name, number, bio))
    println("${contact.getName} Saved to contact list.")
    return contact
}