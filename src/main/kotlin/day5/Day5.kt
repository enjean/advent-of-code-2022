package day5

import util.ParseUtil

fun parseCrates(cratesStrings: List<String>): List<List<Char>> {
    val crateNumbers = cratesStrings.last()
    val numCrates = crateNumbers.trimEnd().last().digitToInt()
    val stacks = List(numCrates) { mutableListOf<Char>() }

    cratesStrings.reversed().drop(1).forEach { line ->
        (1..numCrates).forEach { crateNum ->
            val index = 1 + (crateNum - 1) * 4
            val crate = try { line[index] } catch (e: Exception) { ' ' }
            if (crate != ' ') {
                stacks[crateNum - 1].add(crate)
            }
        }
    }
    return stacks
}

private val instructionRegex = """move (\d+) from (\d) to (\d)""".toRegex()

fun parseInstructions(instructionsStrings: List<String>): List<Instruction> =
    instructionsStrings.map(::parseInstruction)

private fun parseInstruction(instructionString: String) =
    instructionRegex.matchEntire(instructionString)?.let { matchResult ->
        Instruction(
            numToMove = matchResult.matchingInt(1),
            fromStack = matchResult.matchingInt(2),
            toStack = matchResult.matchingInt(3),
        )
    } ?: throw IllegalArgumentException("String did not match regex: $instructionString")

private fun MatchResult.matchingInt(groupIndex: Int) =
    checkNotNull(groups[groupIndex]).value.toInt()

fun calculateTopCratesAfterMoving(
    startingStacks: List<List<Char>>,
    instructions: List<Instruction>,
): String {
    val stacks = startingStacks.map(::ArrayDeque)
    instructions.forEach { instruction ->
        val fromStack = stacks[instruction.fromStack - 1]
        val toStack = stacks[instruction.toStack - 1]

        repeat(instruction.numToMove) {
            toStack.addLast(fromStack.removeLast())
        }
    }
    val topCrates = stacks.map { it.last() }
    return String(topCrates.toCharArray())
}

fun calculateTopCratesAfterMoving2(
    startingStacks: List<List<Char>>,
    instructions: List<Instruction>,
): String {
    val stacks = startingStacks.map { it.toMutableList() }
    instructions.forEach { instruction ->
        val fromStack = stacks[instruction.fromStack - 1]
        val toStack = stacks[instruction.toStack - 1]

        val removeStartingFrom = fromStack.size - instruction.numToMove
        repeat(instruction.numToMove) {
            toStack.add(fromStack.removeAt(removeStartingFrom))
        }
    }
    val topCrates = stacks.map { it.last() }
    return String(topCrates.toCharArray())
}

fun main() {
    val parseGroups = ParseUtil.parseGroups(ParseUtil.inputLines(5))

    val startingStacks = parseCrates(parseGroups[0])
    val instructions = parseInstructions(parseGroups[1])

    val endResult = calculateTopCratesAfterMoving(startingStacks, instructions)
    println("Part 1 = $endResult")

    val crateMover9001Result = calculateTopCratesAfterMoving2(startingStacks, instructions)
    println("Part 2 = $crateMover9001Result")
}