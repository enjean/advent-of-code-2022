package day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class Day2KtTest {
    @ParameterizedTest
    @ArgumentsSource(FindResultArgumentsProvider::class)
    fun `find result test`(
        round: Round,
        expectedResult: Result
    ) {
        assertEquals(expectedResult, findResult(round))
    }

    class FindResultArgumentsProvider: ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> =
            Stream.of(
                Arguments.of(Round(opponentSelection = Shape.ROCK, mySelection = Shape.PAPER), Result.WIN),
                Arguments.of(Round(opponentSelection = Shape.ROCK, mySelection = Shape.SCISSORS), Result.LOSS),
                Arguments.of(Round(opponentSelection = Shape.ROCK, mySelection = Shape.ROCK), Result.DRAW),
                Arguments.of(Round(opponentSelection = Shape.PAPER, mySelection = Shape.SCISSORS), Result.WIN),
                Arguments.of(Round(opponentSelection = Shape.PAPER, mySelection = Shape.ROCK), Result.LOSS),
                Arguments.of(Round(opponentSelection = Shape.PAPER, mySelection = Shape.PAPER), Result.DRAW),
                Arguments.of(Round(opponentSelection = Shape.SCISSORS, mySelection = Shape.ROCK), Result.WIN),
                Arguments.of(Round(opponentSelection = Shape.SCISSORS, mySelection = Shape.PAPER), Result.LOSS),
                Arguments.of(Round(opponentSelection = Shape.SCISSORS, mySelection = Shape.SCISSORS), Result.DRAW),
            )
    }

    @ParameterizedTest
    @ArgumentsSource(ScoreRoundTestArgumentsProvider::class)
    fun `score round test`(
        round: Round,
        expectedScore: Int
    ) {
        assertEquals(expectedScore, scoreRound(round))
    }

    class ScoreRoundTestArgumentsProvider: ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> =
            Stream.of(
                Arguments.of(Round(opponentSelection = Shape.ROCK, mySelection = Shape.PAPER), 8),   // Paper(2) + Win(6)
                Arguments.of(Round(opponentSelection = Shape.PAPER, mySelection = Shape.ROCK), 1),   // Rock(1) + Loss(0)
                Arguments.of(Round(opponentSelection = Shape.SCISSORS, mySelection = Shape.SCISSORS), 6), // Scissors(3) + Draw (3)
            )

    }
}