package day4

data class PairSectionAssignment(
    val firstElfSections: IntRange,
    val secondElfSections: IntRange,
) {
    fun oneAssignmentContainsTheOther(): Boolean =
        firstElfSections.fullyContains(secondElfSections) || secondElfSections.fullyContains(firstElfSections)

    fun hasOverlap(): Boolean =
        firstElfSections.overlaps(secondElfSections) || secondElfSections.overlaps(firstElfSections)

    private fun IntRange.fullyContains(other: IntRange) =
        this.first <= other.first && this.last >= other.last

    private fun IntRange.overlaps(other: IntRange) =
        this.first >= other.first && this.first <= other.last
}
