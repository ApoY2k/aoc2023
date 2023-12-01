package apoy2k.aoc2023.problem1

import apoy2k.aoc2023.readInput

fun main() {
    val map = mapOf(
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
    val result = readInput("problem1/input.txt").lines()
        .map { line ->
            var result = ""
            var currentMatch = ""
            line.forEach {
                currentMatch += it
                if (it.isNumber()) {
                    result += currentMatch
                    currentMatch = ""
                }
                val foundKey = map.keys.firstOrNull { k -> currentMatch.contains(k) }
                if (foundKey != null) {
                    result += map[foundKey]
                    currentMatch = ""
                }
            }
            result
        }
        .sumOf { line ->
            val numbers = match.findAll(line).map { it.value }
            val result = "${numbers.first()}${numbers.last()}"
            println(result)
            result.toInt()
        }
    println(result)
}

private val match = "\\d".toRegex()
private fun Char.isNumber() = match.matches(this.toString())
