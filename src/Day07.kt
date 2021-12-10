import kotlin.math.absoluteValue

fun main() {
    fun med(list: List<Int>) = list.sorted().let {
        if (it.size % 2 == 0)
            (it[it.size / 2] + it[(it.size - 1) / 2]) / 2
        else
            it[it.size / 2]
    }

    fun part1(input: List<String>): Int {
        val nums = input[0].split(",").map { it.toInt() }
        val avg = med(nums)
        return nums.map { (it - avg).absoluteValue }.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day07_test")
    check(part1(testInput) == 37)

    val input = readInput("Day07")
    println(part1(input))
}