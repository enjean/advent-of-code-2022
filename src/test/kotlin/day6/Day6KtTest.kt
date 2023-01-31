package day6

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class Day6KtTest {
    @ParameterizedTest
    @ArgumentsSource(value = FindDistinctCharactersArgumentsProvider::class)
    fun `find distinct characters`(
        input: String, numDistinct: Int,
        expectedNumberOfCharactersBeforeMarker: Int,
    ){
        assertEquals(expectedNumberOfCharactersBeforeMarker, findDistinctCharacters(input, numDistinct))
    }

    private class FindDistinctCharactersArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> =
            Stream.of(
                Arguments.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 4, 7),
                Arguments.of("bvwbjplbgvbhsrlpgdmjqwftvncz", 4, 5),
                Arguments.of("nppdvjthqldpwncqszvftbrmjlhg", 4, 6),
                Arguments.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 4, 10),
                Arguments.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 4, 11),
                Arguments.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 14, 19),
                Arguments.of("bvwbjplbgvbhsrlpgdmjqwftvncz", 14, 23),
                Arguments.of("nppdvjthqldpwncqszvftbrmjlhg", 14, 23),
                Arguments.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 14, 29),
                Arguments.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 14, 26),
            )
    }
}