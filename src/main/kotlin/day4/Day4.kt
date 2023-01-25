package day4

import util.ParseUtil

private val sectionAssignmentRegex = """(\d+)-(\d+),(\d+)-(\d+)""".toRegex()

fun parseSectionAssignmentPair(pairString: String): PairSectionAssignment {
    val matchResult = checkNotNull(sectionAssignmentRegex.matchEntire(pairString))
    return PairSectionAssignment(
        firstElfSections = IntRange(matchResult.matchingInt(1), matchResult.matchingInt(2)),
        secondElfSections = IntRange(matchResult.matchingInt(3), matchResult.matchingInt(4))
    )
}

private fun MatchResult.matchingInt(groupIndex: Int) =
    checkNotNull(groups[groupIndex]).value.toInt()

fun main() {
    val assignments = ParseUtil.inputLines(4).map(::parseSectionAssignmentPair)

    val countOfFullyContained = assignments.count(PairSectionAssignment::oneAssignmentContainsTheOther)
    println("Part 1 = $countOfFullyContained")

    val countOfOverlaps = assignments.count(PairSectionAssignment::hasOverlap)
    println("Part 2 = $countOfOverlaps")
}