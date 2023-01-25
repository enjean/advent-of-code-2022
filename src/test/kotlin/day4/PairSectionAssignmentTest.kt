package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class PairSectionAssignmentTest {
    @ParameterizedTest
    @ArgumentsSource(value = ContainsTestArgumentsProvider::class)
    fun `oneAssignmentContainsTheOther examples`(
        pairSectionAssignment: PairSectionAssignment,
        expectedOneAssignmentContainsTheOther: Boolean) {
        assertEquals(expectedOneAssignmentContainsTheOther, pairSectionAssignment.oneAssignmentContainsTheOther())
    }

    private class ContainsTestArgumentsProvider: ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> =
            Stream.of(
                Arguments.of(PairSectionAssignment(2..4,6..8), false),
                Arguments.of(PairSectionAssignment(2..3,4..5), false),
                Arguments.of(PairSectionAssignment(5..7,7..9), false),
                Arguments.of(PairSectionAssignment(2..8,3..7), true),
                Arguments.of(PairSectionAssignment(6..6,4..6), true),
                Arguments.of(PairSectionAssignment(2..6,4..8), false),
            )
    }
}