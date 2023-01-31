package day6

import util.ParseUtil
import java.util.*

fun findDistinctCharacters(input: String, numDistinct: Int): Int {
    val charactersQueue: Queue<Char> = LinkedList()
    input.forEachIndexed { index, c ->
        if (charactersQueue.size == numDistinct) {
            charactersQueue.remove()
        }
        charactersQueue.add(c)
        if (charactersQueue.distinct().size == numDistinct) {
            return index + 1
        }
    }
    throw IllegalArgumentException("Condition not found")
}

fun main() {
    val input = ParseUtil.inputLines(6).single()

    val part1 = findDistinctCharacters(input, 4)
    println("Part 1 = $part1")

    val part2 = findDistinctCharacters(input, 14)
    println("Part 2 = $part2")
}