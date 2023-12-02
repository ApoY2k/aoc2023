package apoy2k.aoc2023

import java.nio.charset.Charset

fun readInput(path: String) = object {}.javaClass
    .getResource("/$path")
    ?.readText(Charset.defaultCharset())
    ?.lines()
    ?.filter { it.isNotBlank() }
    ?: throw Exception("Empty input file at $path")
