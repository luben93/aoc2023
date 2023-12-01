
fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { row ->
            "${row.first { it.isDigit() }}${row.last { it.isDigit() }}".toInt()
        }
    }


    fun convertNumbers(value:String) = when(value){
        "one" -> "1"
        "two" -> "2"
        "three" -> "3"
        "four" -> "4"
        "five" -> "5"
        "six" -> "6"
        "seven" -> "7"
        "eight" -> "8"
        "nine" -> "9"
        else -> ""
    }
    val numbersRegex = Regex("one|two|three|four|five|six|seven|eight|nine")
    tailrec fun findLast(row: String,index:Int = row.length - 1):Char{
        val digit = row.substring(index,row.length).replace(numbersRegex) { convertNumbers(it.value)}.first()
        return if(digit.isDigit()){
            digit
        }else{
            findLast(row,index-1)
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { row ->
            val digits = row.replace(Regex(numbersRegex.pattern)) { convertNumbers(it.value) }
            "${digits.first { it.isDigit() }}${findLast(row)}".toInt()
        }
    }


    check(part1(readInput("Day01_test")) == 142)
    check(part2(readInput("Day01_test2")) == 281+91)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}


