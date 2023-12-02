package apoy2k.aoc2023.problem2

import apoy2k.aoc2023.readInput
import java.util.regex.Pattern
import kotlin.math.max

fun main() {
    val games = readInput("problem2.txt")
    val part1 = part1(games)
    val part2 = part2(games)
    println("Part 1: $part1")
    println("Part 2: $part2")
}

private fun part1(games: List<String>) = games.sumOf { game ->
    val allPullsOk = game.split(";").all { pulls ->
        val blues = colorAmount(pulls, bluePattern)
        val greens = colorAmount(pulls, greenPattern)
        val reds = colorAmount(pulls, redPattern)
        reds <= 12 && greens <= 13 && blues <= 14
    }
    val id = gamePattern.matcher(game).let {
        it.find()
        it.group(1).toInt()
    }
    if (allPullsOk) id else 0
}

private fun part2(games: List<String>) = games.sumOf { game ->
    val pulls = mutableMapOf(
        "blues" to 0,
        "greens" to 0,
        "reds" to 0,
    )
    game.split(";").forEach {
        pulls["blues"] = max(colorAmount(it, bluePattern), pulls["blues"] ?: 0)
        pulls["greens"] = max(colorAmount(it, greenPattern), pulls["greens"] ?: 0)
        pulls["reds"] = max(colorAmount(it, redPattern), pulls["reds"] ?: 0)
    }
    (pulls["blues"] ?: 0) * (pulls["greens"] ?: 0) * (pulls["reds"] ?: 0)
}

private fun colorAmount(game: String, pattern: Pattern) = pattern.matcher(game).let {
    if (it.find()) it.group(1).toInt() else 0
}

private val gamePattern = "Game (\\d+):".toPattern()
private val bluePattern = "(\\d+) blue".toPattern()
private val greenPattern = "(\\d+) green".toPattern()
private val redPattern = "(\\d+) red".toPattern()
