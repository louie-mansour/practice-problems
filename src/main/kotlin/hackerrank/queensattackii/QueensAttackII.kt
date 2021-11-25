package hackerrank.queensattackii

import org.junit.jupiter.api.Test

class QueensAttackII {
    fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<Array<Int>>): Int {
        // Write your code here
        val validDirections = listOf(
            Pair(1, 0), Pair(1, 1), Pair(0, 1), Pair(-1, 1),
            Pair(-1, 0), Pair(-1, -1), Pair(0, -1), Pair(1, -1)
        )
        val queenPos = Pair(r_q - 1, c_q - 1)
        val obstacleSet = obstacles.map { Pair(it[0] - 1, it[1] - 1) }.toSet()

        var spaces = 0
        for(direction in validDirections) {
            spaces += searchDirection(queenPos, n, obstacleSet, direction)
        }
        return spaces
    }

    private fun searchDirection(pos: Pair<Int, Int>, n: Int, obstacles: Set<Pair<Int, Int>>, dir: Pair<Int, Int>): Int {
        var numberOfPositions = 0
        var square = Pair(pos.first + dir.first, pos.second + dir.second)
        while(square.first < n && square.second < n && square.first >= 0 && square.second >= 0 && !obstacles.contains(square)) {
            numberOfPositions++
            square = Pair(square.first + dir.first, square.second + dir.second)
        }
        return numberOfPositions
    }

    @Test
    fun test() {
        println(queensAttack(4, 0, 4, 4, emptyArray()))
    }
}