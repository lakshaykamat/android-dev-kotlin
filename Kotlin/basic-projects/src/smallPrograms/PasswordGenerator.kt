package smallPrograms

import readPasswordLength
import readYesNoInput

fun generatePassword(
    length: Int,
    passwordChars: Map<String, String>,
    hasUpperCase: Boolean,
    hasLowerCase: Boolean,
    hasNumbers: Boolean,
    hasSpecialChars: Boolean
): String {
    val charset = buildCharSet(
        hasUpperCase to passwordChars["upper-case"],
        hasNumbers to passwordChars["numbers"],
        hasLowerCase to passwordChars["small-case"],
        hasSpecialChars to passwordChars["special-characters"]
    )
    return (1..length)
        .map { charset.random() }
        .joinToString("")
}

fun buildCharSet(vararg charSets: Pair<Boolean, String?>): String {
    return charSets
        .filter { it.first }
        .mapNotNull { it.second }
        .joinToString("")
}

fun main() {
    val passwordCharacters: Map<String, String> = mapOf(
        "small-case" to "abcdefghijklmnopqrstuvwxyz",
        "upper-case" to "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
        "numbers" to "0123456789",
        "special-characters" to "!@#$%^&*()_+"
    )

    try {
        val passwordLength: Int = readPasswordLength()
        val hasUpperCaseLetter: Boolean = readYesNoInput("Uppercase letters")
        val hasNumbers: Boolean = readYesNoInput("Numbers")
        val hasLowerCaseLetter: Boolean = readYesNoInput("Lowercase letters")
        val hasSpecialChars: Boolean = readYesNoInput("Special Characters")

        val password = generatePassword(
            passwordLength,
            passwordCharacters,
            hasUpperCaseLetter,
            hasLowerCaseLetter,
            hasNumbers,
            hasSpecialChars
        )

        println("Generated Password: $password")
    } catch (e: NumberFormatException) {
        println("Enter a valid number for password length")
    }
}