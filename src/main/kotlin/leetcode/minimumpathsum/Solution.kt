package leetcode.minimumpathsum

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
 */

class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        return minPathSum(grid, grid.size-1, grid[0].size-1, mutableMapOf())
    }

    private fun minPathSum(grid: Array<IntArray>, r: Int, c: Int, memo: MutableMap<Pair<Int, Int>, Int>): Int {
        val memoVal = memo[Pair(r, c)]
        if(memoVal != null) {
            return memoVal
        }
        val value = if(r > 0 && c > 0) {
            grid[r][c] + Math.min(minPathSum(grid, r-1, c, memo), minPathSum(grid, r, c-1, memo))
        } else if(r > 0) {
            grid[r][c] + minPathSum(grid, r-1, c, memo)
        } else if(c > 0) {
            grid[r][c] + minPathSum(grid, r, c-1, memo)
        } else {
            grid[r][c]
        }
        memo[Pair(r, c)] = value
        return value
    }
}