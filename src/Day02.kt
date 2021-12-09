fun main() {
    fun part1(input: List<String>): Int {
        var pos = 0
        var depth = 0

        input.forEach {
            var parts = it.split(" ")
            when (parts[0]) {
                "forward" -> pos += parts[1].toInt()
                "down" -> depth += parts[1].toInt()
                "up" -> depth -= parts[1].toInt()
            }
        }

        return pos * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)

    val input = readInput("Day02")
    println(part1(input))
}
