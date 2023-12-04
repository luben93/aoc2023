import kotlin.math.max
import kotlin.math.min

fun main() {
    val symbols = Regex("[^.\\d]")

    fun part1(input: List<String>): Int {

        val rows = input.mapIndexed{ rowIndex,row ->
            Regex("\\d+").findAll(row).sumOf { number ->
                val start = number.range.first
                val end = number.range.last
                val symbolAdjecent = IntRange(rowIndex-1,rowIndex+1)
                    .map { runCatching {
                        input[it].substring (max(start-1,0),min(end+2,row.length)).contains(symbols)
                    }.getOrDefault(false) }.contains(true)
                if(symbolAdjecent){
                    number.value.toInt()
                }else{
                    0
                }
            }
        }
        return rows.sum()
    }


    fun part2(input: List<String>): Int {
       return 0
    }

    check(part1(readInput("Day03_test")) == 4361)
//    check(part1(readInput("Day02_test2")) == 30+11+12)

//    check(part2(readInput("Day02_test2")) == 281+91)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}

