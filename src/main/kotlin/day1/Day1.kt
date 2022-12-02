package day1

import util.ParseUtil

fun findMaxCarried(caloriesCarried: List<List<Int>>) : Int =
    caloriesCarried.maxOf { it.sum() }

fun main() {
    val inputLines = ParseUtil.inputLines(1)
    val inputAsInts = ParseUtil.parseGroups(inputLines).map { it.map { str -> str.toInt() } }
    val sums = inputAsInts.map { it.sum() }
    val sortedSums = sums.sorted().reversed()

    println("Part 1: ${sortedSums.first()}")

    val part2 = sortedSums[0] + sortedSums[1] + sortedSums[2]
    println("Part 2: $part2")
}