package leetcode.spiralmatrix

import java.util.ArrayList

/*
Given an m x n matrix, return all elements of the matrix in spiral order.
 */

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val ans = ArrayList<Int>()
        if (matrix.isEmpty()) return ans
        var r1 = 0
        var r2 = matrix.size - 1
        var c1 = 0
        var c2: Int = matrix[0].size - 1
        while (r1 <= r2 && c1 <= c2) {
            for (c in c1..c2) ans.add(matrix[r1][c])
            for (r in r1 + 1..r2) ans.add(matrix[r][c2])
            if (r1 < r2 && c1 < c2) {
                for (c in c2 - 1 downTo c1 + 1) ans.add(matrix[r2][c])
                for (r in r2 downTo r1 + 1) ans.add(matrix[r][c1])
            }
            r1++
            r2--
            c1++
            c2--
        }
        return ans
    }
}