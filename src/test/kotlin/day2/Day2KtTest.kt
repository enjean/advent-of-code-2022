package day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class Day2KtTest {
    @Nested
    inner class Part1 {
        @ParameterizedTest
        @ArgumentsSource(FindResultArgumentsProvider::class)
        fun `find result test`(
            round: Round,
            expectedResult: Result
        ) {
            assertEquals(expectedResult, findResult(round))
        }

        @ParameterizedTest
        @ArgumentsSource(ScoreRoundTestArgumentsProvider::class)
        fun `score round test`(
            round: Round,
            expectedScore: Int
        ) {
            assertEquals(expectedScore, scoreRound(round))
        }
    }

    @Nested
    inner class Part2 {
        @ParameterizedTest
        @ArgumentsSource(value = FindMySelectionArgumentsProvider::class)
        fun `find my selection test`(
            round2: Round2,
            expectedShape: Shape,
        ) {
            assertEquals(expectedShape, findMySelection(round2))
        }

        @ParameterizedTest
        @ArgumentsSource(value = ScoreRound2TestArgumentsProvider::class)
        fun `score round test`(
            round2: Round2,
            expectedScore: Int,
        ) {
            assertEquals(expectedScore, scoreRound(round2))
        }
    }

    class FindResultArgumentsProvider : ArgumentsProvider {
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

    class ScoreRoundTestArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> =
            Stream.of(
                Arguments.of(
                    Round(opponentSelection = Shape.ROCK, mySelection = Shape.PAPER),
                    8
                ),   // Paper(2) + Win(6)
                Arguments.of(
                    Round(opponentSelection = Shape.PAPER, mySelection = Shape.ROCK),
                    1
                ),   // Rock(1) + Loss(0)
                Arguments.of(
                    Round(opponentSelection = Shape.SCISSORS, mySelection = Shape.SCISSORS),
                    6
                ), // Scissors(3) + Draw (3)
            )

    }

    class FindMySelectionArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> =
            Stream.of(
                Arguments.of(Round2(opponentSelection = Shape.ROCK, desiredResult = Result.WIN), Shape.PAPER),
                Arguments.of(Round2(opponentSelection = Shape.ROCK, desiredResult = Result.LOSS), Shape.SCISSORS),
                Arguments.of(Round2(opponentSelection = Shape.ROCK, desiredResult = Result.DRAW), Shape.ROCK),
                Arguments.of(Round2(opponentSelection = Shape.PAPER, desiredResult = Result.WIN), Shape.SCISSORS),
                Arguments.of(Round2(opponentSelection = Shape.PAPER, desiredResult = Result.LOSS), Shape.ROCK),
                Arguments.of(Round2(opponentSelection = Shape.PAPER, desiredResult = Result.DRAW), Shape.PAPER),
                Arguments.of(Round2(opponentSelection = Shape.SCISSORS, desiredResult = Result.WIN), Shape.ROCK),
                Arguments.of(Round2(opponentSelection = Shape.SCISSORS, desiredResult = Result.LOSS), Shape.PAPER),
                Arguments.of(Round2(opponentSelection = Shape.SCISSORS, desiredResult = Result.DRAW), Shape.SCISSORS),
            )
    }

    class ScoreRound2TestArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> =
            Stream.of(
                Arguments.of(
                    Round2(opponentSelection = Shape.ROCK, desiredResult = Result.DRAW),
                    4
                ),   // Rock(1) + Draw(3)
                Arguments.of(
                    Round2(opponentSelection = Shape.PAPER, desiredResult = Result.LOSS),
                    1
                ),   // Rock(1) + Loss(0)
                Arguments.of(
                    Round2(opponentSelection = Shape.SCISSORS, desiredResult = Result.WIN),
                    7
                ), // Rock(1) + Win (6)
            )

    }
}