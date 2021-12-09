import java.lang.Math.pow

fun main() {
    fun part1(input: List<String>): Int {
        var result = ""
        for (index in input.first().indices) {
            var total0 = 0
            var total1 = 0
            input.forEach {
                when (it[index]) {
                    '0' -> total0++
                    '1' -> total1++
                }
            }
            if (total1 > total0) result += "1" else result += "0"
        }
        val num = Integer.parseInt(result, 2)
        val inverse = pow(2.0, input.first().length.toDouble()) - 1 - num
        return (num * inverse).toInt()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)

    val input = readInput("Day03")
    println(part1(input))
}
