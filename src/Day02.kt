import kotlin.math.max
enum class cubes(val amount:Int){
    red(12),
    green(13),
    blue(14)
}
fun main() {

    tailrec fun maxForColor(game:List<String>,color: String, index: Int = 1):Int{
        if(index >= game.size) return 0
        val current = game[index]
            .split(", ")
            .firstOrNull { it.contains(color) }
            ?.replace(color,"")
//            ?.trim()
            ?.toInt() ?: 0
        return max(current,maxForColor(game, color, index+1))
    }

    fun part1(input: List<String>): Int {
        val matches = input.filter { row ->
            val (id, games) = row.split(": ")
            val listOfGames = games.split("; ")
            listOfGames.map { column ->
                column.split(", ").forEach {
                    val (count,color) = it.split(" ")
                    if(cubes.valueOf(color).amount < count.toInt()) return@filter false
                }
            }
            true
        }
        return matches.sumOf { it.substringAfter("Game ").substringBefore(":").toInt() }
    }


    fun part2(input: List<String>): Int {
        val matches = input.sumOf { row ->
            val (_, games) = row.split(": ")
            val listOfGames = games.split("; ")
            val highestColors = listOfGames.fold(Triple(0,0,0)) { acc, column ->
                val colors = column.split(", ").associate {
                    val (count,color) = it.split(" ")
                    color to count.toInt()
                }
                Triple(max(acc.first,colors.getOrDefault("red",0)),
                    max(acc.second,colors.getOrDefault("green",0)),
                    max(acc.third,colors.getOrDefault("blue",0)))
            }
            highestColors.first*highestColors.second*highestColors.third

        }
        return matches
    }

    check(part1(readInput("Day02_test")) == 8)
    check(part1(readInput("Day02_test2")) == 30+11+12)

    check(part2(readInput("Day02_test")) == 2286)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

//fun List<String>.cubes(color:String) = first { it.contains(color) }.trimStart().split(" ").first().toInt()

