package day1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day1KtTest {
    @Test
    fun `Part 1 example`() {
        val input = listOf(
            listOf(1000, 2000, 3000),
            listOf(4000),
            listOf(5000, 6000),
            listOf(7000, 8000, 9000),
            listOf(10000),
        )

        val result = findMaxCarried(input)

        assertEquals(24000, result)
    }
}