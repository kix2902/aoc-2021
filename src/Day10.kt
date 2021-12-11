import java.util.*

fun main() {
    val open = arrayOf('(', '[', '{', '<')
    val close = arrayOf(')', ']', '}', '>')
    val relation = mapOf(')' to '(', ']' to '[', '}' to '{', '>' to '<')

    fun Char.isOpen(): Boolean {
        return open.contains(this)
    }

    fun Char.isClose(): Boolean {
        return close.contains(this)
    }

    fun part1(input: List<String>): Int {
        val illegal = mutableListOf<Char>()
        input.forEach { line ->
            val opened = ArrayDeque<Char>()
            line.forEach lineFor@{
                when {
                    it.isOpen() -> opened.push(it)
                    it.isClose() -> {
                        if (opened.pop() != relation[it]) {
                            illegal.add(it)
                            return@lineFor
                        }
                    }
                }
            }
        }

        return illegal.map {
            when (it) {
                ')' -> 3
                ']' -> 57
                '}' -> 1197
                '>' -> 25137
                else -> 0
            }
        }.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day10_test")
    check(part1(testInput) == 26397)

    val input = readInput("Day10")
    println(part1(input))
}