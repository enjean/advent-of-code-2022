package day6

import util.ParseUtil
import java.util.*

fun charactersBeforeMarker(input: String): Int {
    val charactersQueue: Queue<Char> = LinkedList()
    input.forEachIndexed { index, c ->
        if (charactersQueue.size == 4) {
            charactersQueue.remove()
        }
        charactersQueue.add(c)
        if (charactersQueue.distinct().size == 4) {
            return index + 1
        }
    }
    throw IllegalArgumentException("Marker not found")
}

fun main() {
    val input = ParseUtil.inputLines(6).single()

    val part1 = charactersBeforeMarker(input)
    println("Part 1 = $part1")
}