package apoy2k.aoc2023.problem1

import apoy2k.aoc2023.readInput

fun main() {
    println("Part 1: ${part1()}")
    println("Part 2: ${part2()}")
}

private fun part1() = solve(map.values.toSet())

private fun part2() = solve(map.keys + map.values)

private fun solve(numbers: Set<String>) = readInput("problem1.txt")
    .sumOf {
        val first = it.findAnyOf(numbers)?.second?.toNumber() ?: error("no first digit for '$it'")
        val last = it.findLastAnyOf(numbers)?.second?.toNumber() ?: error("no last digit for '$it'")
        "$first$last".toInt()
    }

private fun String.toNumber() = toIntOrNull() ?: map[this]?.toInt() ?: error("cannot convert '$this' to number")

private val map = mapOf(
    "one" to "1",
    "two" to "2",
    "three" to "3",
    "four" to "4",
    "five" to "5",
    "six" to "6",
    "seven" to "7",
    "eight" to "8",
    "nine" to "9"
)
