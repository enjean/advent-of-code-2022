package day1

import util.ParseUtil

fun findMaxCarried(caloriesCarried: List<List<Int>>) : Int =
    caloriesCarried.maxOf { it.sum() }

fun main() {
    val inputLines = ParseUtil.inputLines(1)
    val inputAsInts = ParseUtil.parseGroups(inputLines).map { it.map { str -> str.toInt() } }

    println("Part 1: ${findMaxCarried(inputAsInts)}")
}