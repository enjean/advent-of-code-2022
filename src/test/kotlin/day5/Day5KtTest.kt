package day5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day5KtTest {

    @Test
    fun `parse crates`() {
        val cratesStrings = listOf(
            "    [D]    ",
            "[N] [C]    ",
            "[Z] [M] [P]",
            " 1   2   3 ",
        )

        assertEquals(sampleStartingStacks, parseCrates(cratesStrings))
    }

    @Test
    fun `parse instructions`() {
        val instructionsStrings = listOf(
            "move 1 from 2 to 1",
            "move 3 from 1 to 3",
            "move 2 from 2 to 1",
            "move 1 from 1 to 2",
        )
        assertEquals(sampleInstructions, parseInstructions(instructionsStrings))
    }

    @Test
    fun `calculate top crates after moving`() {
        val result = calculateTopCratesAfterMoving(sampleStartingStacks, sampleInstructions)

        assertEquals("CMZ", result)
    }

    companion object {
        private val sampleStartingStacks = listOf(
                listOf('Z', 'N'),
                listOf('M', 'C', 'D'),
                listOf('P'),
            )
        private val sampleInstructions = listOf(
                Instruction(numToMove = 1, fromStack = 2, toStack = 1),
                Instruction(numToMove = 3, fromStack = 1, toStack = 3),
                Instruction(numToMove = 2, fromStack = 2, toStack = 1),
                Instruction(numToMove = 1, fromStack = 1, toStack = 2),
            )
    }
}