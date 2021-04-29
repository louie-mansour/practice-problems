package leetcode.searcha2dmatrix

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

 */

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val i = binarySearchRow(matrix, target, 0, matrix.size - 1)
        return binarySearchCol(matrix[i], target, 0, matrix[i].size - 1)
    }

    private fun binarySearchRow(matrix: Array<IntArray>, target: Int, l: Int, r: Int): Int {
        var l = l
        var r = r
        var mid: Int
        while(l <= r) {
            mid = (l + r) / 2
            if(target < matrix[mid][0]) {
                r = mid - 1
            } else if(target > matrix[mid][0]) {
                l = mid + 1
            } else {
                return mid
            }
        }
        return (l + r) / 2
    }

    private fun binarySearchCol(col: IntArray, target: Int, l: Int, r: Int): Boolean {
        var l = l
        var r = r
        var mid: Int
        while(l <= r) {
            mid = (l + r) / 2
            if(target < col[mid]) {
                r = mid - 1
            } else if(target > col[mid]) {
                l = mid + 1
            } else {
                return true
            }
        }
        return false
    }
}