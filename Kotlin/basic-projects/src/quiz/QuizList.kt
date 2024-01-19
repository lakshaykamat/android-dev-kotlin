package quiz


object QuizList {
    val quizzes = listOf(
        QuizModel(
            question = "What is the capital of France?",
            options = listOf(
                OptionsModel("Berlin", false),
                OptionsModel("Madrid", false),
                OptionsModel("Paris", true),
                OptionsModel("Rome", false)
            )
        ),

        QuizModel(
            question = "Who is the author of 'Romeo and Juliet'?",
            options = listOf(
                OptionsModel("Charles Dickens", false),
                OptionsModel("William Shakespeare", true),
                OptionsModel("Jane Austen", false),
                OptionsModel("Mark Twain", false)
            )
        ),
        // Add more real-world quiz questions as needed
    )
}