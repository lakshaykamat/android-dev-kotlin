package quiz

object User {
    private var _username: String = ""
    private var _score: Int = 0
    private var _correctAnswers = 0
    private var _wrongAnswers = 0

    fun setUserName(name: String): String {
        _username = name
        return _username
    }

    fun getUsername(): String {
        return _username
    }

    fun getScore(): Int {
        return _score
    }

    fun getRightAnswers(): Int {
        return _correctAnswers
    }

    fun getWrongAnswers(): Int {
        return _wrongAnswers
    }

    fun hasRightAnswer() {
        _score += 5
        _correctAnswers += 1
    }

    fun hasWrongAnswer() {
        if (_score != 0) _score -= 2
        _wrongAnswers += 1
    }

    fun printScore() {
        val message = "Total Score:$_score\nCorrect Answers:$_correctAnswers\nWrong Answers:$_wrongAnswers"
        println(message)
    }
}

object UserInput {
    val allowedOption1 = setOf('a', 'A', '1')
    val allowedOption2 = setOf('b', 'B', '2')
    val allowedOption3 = setOf('c', 'C', '3')
    val allowedOption4 = setOf('d', 'D', '4')
    private val allowedOptions = setOf(allowedOption1, allowedOption2, allowedOption3, allowedOption4)

    fun isValid(char: Char): Boolean {
        return allowedOptions.any { it.contains(char) }
    }

}

