fun main() {
    val programsMap: Map<Int,String> = mapOf(
        1 to "Contact Manager",
        2 to "Quiz CLI",
        3 to "Unit Convertor CLI",
    )
    programsMap.forEach { (key, value) ->
        println("$key. $value")
    }
    val n = readNumber("Enter Program no: ")
    when(n){
        1 -> contactBook.main()
        2 -> quiz.main()
        3 -> unitConvertor.main()
        else -> println("Invalid number.")
    }
}