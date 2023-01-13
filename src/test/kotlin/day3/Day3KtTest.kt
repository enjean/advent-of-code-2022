package day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class Day3KtTest {

    @ParameterizedTest
    @ArgumentsSource(value = DuplicatedItemPriorityTestArgumentsProvider::class)
    fun `find priority of item included in both compartments`(
        rucksackContents: String,
        expectedPriority: Int,
    ) {
        assertEquals(expectedPriority, priorityOfItemInBothCompartments(rucksackContents))
    }

    class DuplicatedItemPriorityTestArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> =
            Stream.of(
                Arguments.of("vJrwpWtwJgWrhcsFMMfFFhFp", 16),
                Arguments.of("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", 38),
                Arguments.of("PmmdzqPrVvPwwTWBwg", 42),
                Arguments.of("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", 22),
                Arguments.of("ttgJtRGJQctTZtZT", 20),
                Arguments.of("CrZsJsPPZsGzwwsLwLmpwMDw", 19),
            )
    }

    @Test
    fun `find badge priorities`() {
        val input = listOf(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw",
        )

        val result = findBadgePriorities(input)

        assertEquals(70, result)
    }
}