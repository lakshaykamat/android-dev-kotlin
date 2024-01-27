import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream
class InputHelperTest{
    @Test
    fun `readYesNoInput should return true for 'y' input`() {
        val input = ByteArrayInputStream("y\n".toByteArray())
        val result = readYesNoInput("Prompt: ", input)
        assertEquals(true, result)
    }

    @Test
    fun `readYesNoInput should return false for 'n' input`() {
        val input = ByteArrayInputStream("n\n".toByteArray())
        val result = readYesNoInput("Prompt: ", input)
        assertEquals(false, result)
    }

    @Test
    fun `readNumber should return the correct integer input`() {
        val input = ByteArrayInputStream("42\n".toByteArray())
        val result = readNumber("Enter number: ", input)
        assertEquals(42, result.toInt())
    }

    @Test
    fun `readNumber should return the correct double input`() {
        val input = ByteArrayInputStream("3.14\n".toByteArray())
        val result = readNumber("Enter number: ", input)
        assertEquals(3.14, result.toDouble())
    }
}