package quiz

import java.io.BufferedWriter
import java.io.FileWriter

object Quiz {
    private const val FILE_NAME = "output.txt"
    fun displayQuestion(quiz: QuizModel) {
        println(quiz.question)

        quiz.options.forEachIndexed { index, option ->
            val letter = ('a' + index).toString()
            println("$letter. ${option.text}")
        }

    }

    fun isCorrectAnswer(question: QuizModel, userAnswer: OptionsModel): Boolean {
        val correctAnswer = question.options.firstOrNull { it.isCorrect }
        return userAnswer == correctAnswer
    }
    fun selectedOption(ans: Char, quiz: QuizModel): OptionsModel {
        val userOption: OptionsModel = when (ans) {
            in UserInput.allowedOption1 -> quiz.options[0]
            in UserInput.allowedOption2 -> quiz.options[1]
            in UserInput.allowedOption3 -> quiz.options[2]
            in UserInput.allowedOption4 -> quiz.options[3]
            else -> quiz.options[(0..3).random()]
        }
        return userOption
    }

    fun addResultToHistory(user: User) {
        // Create the content using String interpolation
        val content = """
        |Name: ${user.getUsername()}
        |Correct Answer: ${user.getRightAnswers()}
        |Wrong Answer: ${user.getWrongAnswers()}
        |Total Score: ${user.getScore()}
    """.trimMargin()

        // Use PrintWriter with BufferedWriter for better performance
        BufferedWriter(FileWriter(FILE_NAME, true)).use { writer ->
            writer.appendLine(content)
        }
    }

}