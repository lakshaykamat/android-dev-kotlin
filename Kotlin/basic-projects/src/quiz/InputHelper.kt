package quiz

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
