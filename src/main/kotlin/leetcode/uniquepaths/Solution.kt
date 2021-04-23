package leetcode.uniquepaths

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
 */

class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        return uniquePathsRec(m - 1, n - 1, mutableMapOf())
    }

    private fun uniquePathsRec(r: Int, c: Int, memo: MutableMap<Pair<Int, Int>, Int>): Int {
        val memoValue = memo[Pair(r, c)]
        if(memoValue != null) {
            return memoValue
        }
        val uniquePaths: Int = if(r > 0 && c > 0) {
            uniquePathsRec(r - 1, c, memo) + uniquePathsRec(r, c - 1, memo)
        } else if(r > 0) {
            uniquePathsRec(r - 1, c, memo)
        } else if(c > 0) {
            uniquePathsRec(r, c - 1, memo)
        } else {
            1
        }
        memo[Pair(r, c)] = uniquePaths
        return uniquePaths
    }
}