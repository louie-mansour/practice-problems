package leetcode.numberofprovinces

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
 */
class NumberOfProvinces {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val cache = mutableSetOf<Int>()
        var count = 0
        for(i in isConnected.indices) {
            if(!cache.contains(i)) count++
            dfs(isConnected, i, cache)

        }
        return count
    }

    private fun dfs(isConnected: Array<IntArray>, i: Int, cache: MutableSet<Int>) {
        if(cache.contains(i)) return
        cache.add(i)
        for(j in isConnected[i].indices) {
            if(isConnected[i][j] == 1) dfs(isConnected, j, cache)
        }
    }

    @Test
    fun test() {
        Assertions.assertEquals(
            2, findCircleNum(listOf(listOf(1, 1, 0), listOf(1, 1, 0), listOf(0, 0, 1)).map { it.toIntArray() }.toTypedArray())
        )

        Assertions.assertEquals(
            3, findCircleNum(listOf(listOf(1, 0, 0), listOf(0, 1, 0), listOf(0, 0, 1)).map { it.toIntArray() }.toTypedArray())
        )

        Assertions.assertEquals(
            1, findCircleNum(
                listOf(listOf(1, 0, 0, 1),
                    listOf(0, 1, 1, 0),
                    listOf(0, 1, 1, 1),
                    listOf(1, 0, 1, 1)).map { it.toIntArray() }.toTypedArray())
        )
    }
}