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
private val shapeLosers = shapeBeaters.entries.associate { it.value to it.key }

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
    val opponentSelection = parseOpponentSelection(moves[0])
    val mySelection = when (moves[1]) {
        "X" -> Shape.ROCK
        "Y" -> Shape.PAPER
        "Z" -> Shape.SCISSORS
        else -> throw IllegalArgumentException("Unexpected $moves[1]")
    }
    return Round(opponentSelection, mySelection)
}

fun parseRound2(line: String): Round2 {
    val lineParts = line.split(" ")
    val opponentSelection = parseOpponentSelection(lineParts[0])
    val desiredResult = when (lineParts[1]) {
        "X" -> Result.LOSS
        "Y" -> Result.DRAW
        "Z" -> Result.WIN
        else -> throw IllegalArgumentException("Unexpected $lineParts[1]")
    }
    return Round2(opponentSelection, desiredResult)
}

private fun parseOpponentSelection(move: String) =
    when (move) {
        "A" -> Shape.ROCK
        "B" -> Shape.PAPER
        "C" -> Shape.SCISSORS
        else -> throw IllegalArgumentException("Unexpected $move")
    }

fun findResult(round: Round): Result =
    when {
        round.mySelection == round.opponentSelection -> Result.DRAW
        shapeBeaters[round.mySelection] == round.opponentSelection -> Result.WIN
        else -> Result.LOSS
    }

fun scoreRound(round: Round): Int =
    round.mySelection.value + findResult(round).score

data class Round2(
    val opponentSelection: Shape,
    val desiredResult: Result,
)

fun findMySelection(round2: Round2): Shape =
    when (round2.desiredResult) {
        Result.DRAW -> round2.opponentSelection
        Result.LOSS -> checkNotNull(shapeBeaters[round2.opponentSelection])
        Result.WIN -> checkNotNull(shapeLosers[round2.opponentSelection])
    }

fun scoreRound(round2: Round2): Int =
    findMySelection(round2).value + round2.desiredResult.score


fun main() {
    val inputLines = ParseUtil.inputLines(2)
    val strategyGuide = inputLines.map(::parseRound)

    val score = strategyGuide.sumOf(::scoreRound)
    println("Part 1 = $score")

    val part2Guide = inputLines.map(::parseRound2)
    val part2Score = part2Guide.sumOf(::scoreRound)
    println("Part 2 = $part2Score")
}