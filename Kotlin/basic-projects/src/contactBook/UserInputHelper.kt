package contactBook

import readNumber

fun readContactName(title: String = "Enter: "): String {
    return readInput(title) { it.length > 3 }
}

fun readContactNumber(title: String = "Enter: "): String {
    return readInput(title) { it.length > 9 }
}

fun readInput(title: String, condition: (String) -> Boolean): String {
    var input: String?
    do {
        print(title)
        input = readlnOrNull()
        if (input == null || !condition(input)) {
            println("Invalid input. Please try again.")
        }
    } while (input == null || !condition(input))
    return input
}

fun readOption(prompt: String, optionMap: Map<Int, MainMenuOptions>): MainMenuOptions {
    var userChoice: MainMenuOptions?
    do {
        showMapItems(optionMap)
        val n = readNumber(prompt)
        userChoice = optionMap[n]
        if (userChoice == null) println("Enter a valid number.")
    } while (userChoice == null)
    return userChoice
}