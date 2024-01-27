import quiz.UserInput
import java.io.InputStream


fun readOptionInput(): Char {
    var input: String? = null
    // Loop until valid input is provided
    while (input.isNullOrEmpty() || input.length != 1 || !UserInput.isValid(input[0])) {
        print("Answer: ")
        input = readlnOrNull()
    }
    return input[0]
}

fun readUsernameInput(): String {
    var input: String? = null
    while (input.isNullOrEmpty() || input.length <= 3) {
        println("Name should be greater than 3 characters")
        print("Enter your name: ")
        input = readlnOrNull()
    }
    return input
}

fun readYesNoInput(title: String, inputStream: InputStream = System.`in`): Boolean {
    var input: String?
    while (true) {
        print(title)
        input = inputStream.bufferedReader().readLine()
        if (!input.isNullOrEmpty() && input.length == 1) {
            return input[0].lowercaseChar() == 'y'
        }
    }
}

fun readPasswordLength(): Int {
    var input: String?
    while (true) {
        print("Password Length: ")
        input = readlnOrNull()
        if (!input.isNullOrEmpty() && input.length < 5) {
            return input.toIntOrNull() ?: continue
        }
    }
}

fun readNumber(title: String = "Enter number: ", inputStream: InputStream = System.`in`): Number {
    var input: String?
    while (true) {
        print(title)
        input = inputStream.bufferedReader().readLine()
        if (!input.isNullOrEmpty()) {
            return input.toIntOrNull() ?: input.toDoubleOrNull() ?: continue
        }
        println("Invalid input. Please enter a valid number.")
    }
}