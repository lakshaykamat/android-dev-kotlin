package quiz

fun main() {
    QuizList.quizzes.forEach {
        Quiz.displayQuestion(it)
        print("Answer: ")
        val ansChoice: Char = readInput() ?: return
        val userOption: OptionsModel = userChoice(ansChoice, it) ?: return
        when (Quiz.isCorrectAnswer(question = it, userAnswer = userOption)) {
            true -> User.score += 5
            false -> {}
        }
    }
    println("Final Score:${User.score}")
}


fun readInput(): Char? {
    val input = readlnOrNull()
    return if (!input.isNullOrEmpty() && input.length == 1) {
        input[0]
    } else {
        null
    }
}

fun userChoice(ans: Char, quiz: QuizModel): OptionsModel? {
    val userOption: OptionsModel? = when (ans) {
        'a' -> quiz.options[0]
        'b' -> quiz.options[1]
        'c' -> quiz.options[2]
        'd' -> quiz.options[3]
        else -> null
    }
    return userOption
}