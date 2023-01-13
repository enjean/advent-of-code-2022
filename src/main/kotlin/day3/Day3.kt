package day3

import util.ParseUtil

fun priorityOfItemInBothCompartments(rucksackContents: String): Int {
    val compartmentSize = rucksackContents.length / 2
    val firstCompartment = rucksackContents.take(compartmentSize)
    val secondCompartment = rucksackContents.takeLast(compartmentSize)
    val duplicatedItem = firstCompartment.first { secondCompartment.contains(it) }
    return if (duplicatedItem.isLowerCase()) {
        duplicatedItem.minus('a') + 1
    } else {
        duplicatedItem.minus('A') + 27
    }
}

fun main() {
    val inputLines = ParseUtil.inputLines(3)

    val part1 = inputLines.sumOf(::priorityOfItemInBothCompartments)
    println("Part 1 = $part1")
}