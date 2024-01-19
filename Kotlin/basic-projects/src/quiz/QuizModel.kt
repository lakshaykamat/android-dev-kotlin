package quiz

data class OptionsModel(val text: String, val isCorrect: Boolean)
data class QuizModel(val question: String, val options: List<OptionsModel>)