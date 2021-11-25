package leetcode.numberofislands

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/*
Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        var islandCount = 0
        for(m in grid.indices) {
            for(n in grid[0].indices) {
                if(grid[m][n] == 'V' || grid[m][n] == '0') continue
                if(grid[m][n] == '1') {
                    dfs(grid, m, n)
                    islandCount++
                }
            }
        }
        return islandCount
    }

    private fun dfs(grid: Array<CharArray>, m: Int, n: Int) {
        if(m > grid.size - 1 || m < 0) return
        if(n > grid[0].size - 1 || n < 0) return
        if(grid[m][n] == 'V') return
        if(grid[m][n] == '0') return

        if(grid[m][n] == '1') grid[m][n] = 'V'
        dfs(grid, m + 1, n)
        dfs(grid, m, n +1)
        dfs(grid, m - 1, n)
        dfs(grid, m, n - 1)
    }

    @Test
    fun test() {
        Assertions.assertEquals(
            numIslands(listOf(
                listOf('1', '1', '1', '1', '0'),
                listOf('1', '1', '0', '1', '0'),
                listOf('1', '1', '0', '0', '0'),
                listOf('0', '0', '0', '0', '0')
            ).map { it.toCharArray() }.toTypedArray()), 1
        )

        Assertions.assertEquals(
            numIslands(listOf(
                listOf('1', '1', '0', '0', '0'),
                listOf('1', '1', '0', '0', '0'),
                listOf('0', '0', '1', '0', '0'),
                listOf('0', '0', '0', '1', '1')
            ).map { it.toCharArray() }.toTypedArray()), 3
        )
    }
}