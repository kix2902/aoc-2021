fun main() {
    fun part1(input: List<String>): Int {
        var polymer = input.first().toCharArray().toList()
        val conversions = input.mapNotNull { line ->
            if (line.contains("->")) {
                line.substringBefore(" ") to line.substringAfterLast(" ")
            } else null
        }.toMap()

        repeat(10) {
            val temp = mutableListOf<Char>()
            polymer.windowed(2) { chars ->
                temp.add(chars[0])
                val selected = conversions.getOrDefault(chars.joinToString(""), null)
                if (selected != null) temp.add(selected[0])
            }
            temp.add(polymer.last())
            polymer = temp
        }

        val counts = polymer.groupingBy { it }.eachCount()
        return counts.maxOf { it.value } - counts.minOf { it.value }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day14_test")
    check(part1(testInput) == 1588)

    val input = readInput("Day14")
    println(part1(input))
}