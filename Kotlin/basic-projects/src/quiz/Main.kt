package quiz

import readOptionInput
import readUsernameInput

fun main() {
    val name: String = readUsernameInput()
    User.setUserName(name)

    QuizList.quizzes.forEach { quiz ->

        //Display question and options
        Quiz.displayQuestion(quiz)

        //Taking user input with some allowed chars
        val ansChoice: Char = readOptionInput()

        //Deciding option based on char input
        val userOption: OptionsModel = Quiz.selectedOption(ansChoice, quiz)


        val isRightAnswer: Boolean = Quiz.isCorrectAnswer(question = quiz, userAnswer = userOption)


        when (isRightAnswer) {
            true -> User.hasRightAnswer()
            false -> User.hasWrongAnswer()
        }
    }
    User.printScore()
    Quiz.addResultToHistory(User)
}
