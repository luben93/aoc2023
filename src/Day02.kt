
fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }


    fun part2(input: List<String>): Int {
        return part1(input)
    }


    check(part1(readInput("Day02_test")) == 142)
    check(part2(readInput("Day02_test2")) == 281+91)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}


