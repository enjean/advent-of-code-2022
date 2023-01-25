package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day4KtTest {
    @Nested
    inner class ParseSectionAssignmentPair {
        @Test
        fun `parse single digit sections`() {
            val result = parseSectionAssignmentPair("2-4,6-8")
            assertEquals(PairSectionAssignment(firstElfSections = 2..4, secondElfSections = 6..8), result)
        }

        @Test
        fun `parse two digit sections`() {
            val result = parseSectionAssignmentPair("35-39,42-44")
            assertEquals(PairSectionAssignment(firstElfSections = 35..39, secondElfSections = 42..44), result)
        }
    }
}