package leetcode.rotateimage

/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.
 */

class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val maxIndex = matrix.size - 1
        var topLeft: Int
        var topRight: Int
        var bottomRight: Int
        var bottomLeft: Int
        for(i in 0..maxIndex / 2) {
            for(j in i until maxIndex - i) {
                topLeft = matrix[i][j]
                topRight = matrix[j][maxIndex - i]
                bottomRight = matrix[maxIndex - i][maxIndex - j]
                bottomLeft = matrix[maxIndex - j][i]

                matrix[j][maxIndex - i] = topLeft
                matrix[maxIndex - i][maxIndex - j] = topRight
                matrix[maxIndex - j][i] = bottomRight
                matrix[i][j] = bottomLeft
            }
        }
    }
}