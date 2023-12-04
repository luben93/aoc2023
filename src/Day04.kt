import kotlin.math.max
import kotlin.math.min

fun main() {

    fun part1(input: List<String>): Int {
        val rows = emptyList<Int>()
        return rows.sum()
    }


    fun part2(input: List<String>): Int {
       return 0
    }

    check(part1(readInput("Day04_test")) == 312)
//    check(part1(readInput("Day02_test2")) == 30+11+12)

//    check(part2(readInput("Day02_test2")) == 281+91)

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}

