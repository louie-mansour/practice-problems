package hackerrank.climbingtheleaderboard

import org.junit.jupiter.api.Test
import java.util.*

class ClimbingTheLeaderboard {
    fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {
        // Write your code here
        val treeMap = TreeMap<Int, Int>()

        val arr = IntArray(ranked.size)
        ranked.forEachIndexed{ i, e -> arr[i] = arr[i]?:0}
        ranked.distinct().forEachIndexed { i, el -> treeMap[el] = i }
        return player.map { findRank(treeMap, it) }.toTypedArray()
    }

    private fun findRank(distinctRanks: TreeMap<Int, Int>, playerScore: Int): Int {
        val nextHeighestScore = distinctRanks.ceilingEntry(playerScore) ?: return 1
        if(nextHeighestScore.key == playerScore) return nextHeighestScore.value + 1
        return nextHeighestScore.value + 2
    }

    @Test
    fun test() {
        climbingLeaderboard(intArrayOf(100, 100, 50, 40, 40, 20, 10).toTypedArray(), intArrayOf(5, 25, 50, 120).toTypedArray())
    }
}