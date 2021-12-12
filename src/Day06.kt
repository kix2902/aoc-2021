fun main() {
    fun part1(input: List<String>): Int {
        var fishes = input[0].split(",").map { it.toInt() }.toMutableList()

        repeat(80) {
            var add = 0
            fishes = fishes.map {
                if (it == 0) {
                    add++
                    7
                } else {
                    it
                }
            }.toMutableList()
            fishes = fishes.map { it - 1 }.toMutableList()
            fishes.addAll(List(add) { 8 })
        }

        return fishes.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 5934)

    val input = readInput("Day06")
    println(part1(input))
}