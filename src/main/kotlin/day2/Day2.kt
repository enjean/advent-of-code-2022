package day2

import util.ParseUtil

enum class Shape(val value: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3),
}

private val shapeBeaters = mapOf(
    Shape.ROCK to Shape.SCISSORS,
    Shape.SCISSORS to Shape.PAPER,
    Shape.PAPER to Shape.ROCK,
)

data class Round(
    val opponentSelection: Shape,
    val mySelection: Shape,
)

enum class Result(val score: Int) {
    WIN(6),
    LOSS(0),
    DRAW(3),
}

fun parseRound(line: String): Round {
    val moves = line.split(" ")
    val opponentSelection = when(moves[0]) {
        "A" -> Shape.ROCK
        "B" -> Shape.PAPER
        "C" -> Shape.SCISSORS
        else -> throw IllegalArgumentException("Unexpected ${moves[0]}")
    }
    val mySelection = when(moves[1]) {
        "X" -> Shape.ROCK
        "Y" -> Shape.PAPER
        "Z" -> Shape.SCISSORS
        else -> throw IllegalArgumentException("Unexpected $moves[1]")
    }
    return Round(opponentSelection, mySelection)
}

fun findResult(round: Round): Result =
    when {
        round.mySelection == round.opponentSelection -> Result.DRAW
        shapeBeaters[round.mySelection] == round.opponentSelection -> Result.WIN
        else -> Result.LOSS
    }

fun scoreRound(round: Round): Int =
    round.mySelection.value + findResult(round).score

fun main() {
    val strategyGuide = ParseUtil.inputLines(2).map(::parseRound)

    val score = strategyGuide.sumOf(::scoreRound)
    println("Part 1 = $score")
}