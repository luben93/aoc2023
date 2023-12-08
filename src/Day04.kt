import kotlin.math.max
import kotlin.math.min

fun main() {
    val card = Regex("Card \\d: ")
    fun part1(input: List<String>): Int {
        val rows = input.mapNotNull { row ->
            val (winning,marks) = row.split(card).last().split("|")
            val winningList = winning.split(" ")
            val marksList = marks.split(" ")
            val winningMarks = marksList.filter { winningList.contains(it) }.mapNotNull { it.takeUnless { it.isBlank() }?.toInt() }.count()
            IntRange(1,winningMarks).reduceOrNull{ acc,_ -> acc*2 }
        }
        println(rows)
        return rows.sum()
    }


    fun part2(input: List<String>): Int {
       return 0
    }

    check(part1(readInput("Day04_test")) == 13)
//    check(part1(readInput("Day02_test2")) == 30+11+12)

//    check(part2(readInput("Day02_test2")) == 281+91)

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}

