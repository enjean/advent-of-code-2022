package day3

import util.ParseUtil

fun priorityOfItemInBothCompartments(rucksackContents: String): Int {
    val compartmentSize = rucksackContents.length / 2
    val firstCompartment = rucksackContents.take(compartmentSize)
    val secondCompartment = rucksackContents.takeLast(compartmentSize)
    val duplicatedItem = firstCompartment.first { secondCompartment.contains(it) }
    return duplicatedItem.priority()
}

fun findBadgePriorities(contentsOfRucksacks: List<String>): Int {
    return contentsOfRucksacks.chunked(3) {
        priorityOfBadge(it[0], it[1], it[2])
    }.sum()
}

fun priorityOfBadge(rucksack1: String, rucksack2: String, rucksack3: String): Int {
    val badge = rucksack1.first { rucksack2.contains(it) && rucksack3.contains(it) }
    return badge.priority()
}

private fun Char.priority() =
    if (this.isLowerCase()) {
        this.minus('a') + 1
    } else {
        this.minus('A') + 27
    }

fun main() {
    val inputLines = ParseUtil.inputLines(3)

    val part1 = inputLines.sumOf(::priorityOfItemInBothCompartments)
    println("Part 1 = $part1")

    val part2 = findBadgePriorities(inputLines)
    println("Part 2 = $part2")
}