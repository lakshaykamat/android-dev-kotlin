fun main() {
    val randomNum: Int = (1..100).random()
    var moves: Int = 0
    val TOTAL_MOVES: Int = 4

    println("Guess the number between 1 and 100.")

    do {
        val userValue = readUserInput()
        moves++
        when {
            randomNum > userValue -> println("Guess a higher number")
            randomNum < userValue -> println("Guess a lower number")
            else -> {
                println("You guessed right!!")
                break
            }
        }
    } while (moves < TOTAL_MOVES)

    println("The number is: $randomNum")
    println("Total Moves taken: $moves")
}

fun readUserInput(): Int {
    var userValue: Int?
    do {
        println("Enter a number between 1-100: ")
        val userInput = readlnOrNull()
        userValue = userInput?.toIntOrNull()
    } while (userValue == null)

    return userValue
}
