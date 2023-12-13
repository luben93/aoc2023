fun main() {
    val card = Regex("Card\\W+(\\d): ")
    fun part1(input: List<String>): Int {
        val rows = input.mapNotNull { row ->
            val (winning,marks) = row.split(card).last().split("|")
            val winningList = winning.split(" ")
            val marksList = marks.split(" ")
            val winningMarks = marksList.filter { winningList.contains(it) }.mapNotNull { it.takeUnless { it.isBlank() }?.toInt() }.count()
            IntRange(1,winningMarks).reduceOrNull{ acc,_ -> acc*2 }
        }
//        println(rows)
        return rows.sum()
    }



    data class Row(val cardId:Int, val winners:Int)


    fun part2loop(input: List<Row>): Int {
        val mutableList = input.toMutableList()
        var index = 0
        while (index < mutableList.size){
            val (cardIndex,winner) = mutableList[index]
             val newCards = mutableList.subList(cardIndex,cardIndex+winner).toList()
            index++
            mutableList.addAll(newCards)

        }
        return mutableList.count()
    }

        fun part2Init(input: List<String>): Int {
        val parsedList = input.map {currentCard ->
            val (cardHeader,values) = currentCard.split(":")
            val currentNumber = cardHeader.substringAfter(" ").trimStart().toInt()

            val (winning, marks) = values.split("|")
            val winningList = winning.split(" ").filterNot { it.isBlank() }
            val marksList = marks.split(" ").filterNot { it.isBlank() }
            val winningMarks = marksList.filter { winningList.contains(it) }.mapNotNull { it.takeUnless { it.isBlank() }?.toInt() }.count()
            Row(currentNumber, winningMarks)
        }.also { println(it) }
        return part2loop(parsedList)
    }
//    check(part1(readInput("Day04_test")) == 13)
    check(part2Init(readInput("Day04_test2")).also { println(it) } == 30)

    val input = readInput("Day04")
    part1(input).println()
    part2Init(input).println()
}

