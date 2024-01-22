package smallPrograms

fun main() {
    val randomNum: Int = (1..100).random()
    var moves = 0
    val TOTAL_MOVES = 4

    do {
        var userValue:Int? = null
        while (userValue === null){
            try {
                println("Guess the number between 1 and 100.")
                userValue = readln().toInt()
            }catch (e:Exception){
                println("Enter number between 1-100 :/")
            }
        }

        moves++
        when {
            randomNum > userValue -> {
                println("Guess a higher number")
            }
            randomNum < userValue -> {
                println("Guess a lower number")
            }
            else -> {
                println("You guessed right!!")
                break
            }
        }
    } while (moves < TOTAL_MOVES)

    println("The number is: $randomNum")
    println("Total Moves taken: $moves")
}