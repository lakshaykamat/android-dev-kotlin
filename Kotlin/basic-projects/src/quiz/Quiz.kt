package quiz

object Quiz {
    fun displayQuestion(quiz: QuizModel) {
        println(quiz.question)
        quiz.options.forEach { println(it.text) }
    }

    fun isCorrectAnswer(question: QuizModel, userAnswer: OptionsModel): Boolean {
        val correctAnswer = question.options.firstOrNull { it.isCorrect }
        return userAnswer == correctAnswer
    }

}