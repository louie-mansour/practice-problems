package leetcode.randomflipmatrix

import kotlin.random.Random


/*
You are given the number of rows n_rows and number of columns n_cols of a 2D binary matrix where all values are initially 0.
Write a function flip which chooses a 0 value uniformly at random, changes it to 1, and then returns the position [row.id, col.id] of that value.
Also, write a function reset which sets all values back to 0.
Try to minimize the number of calls to system's Math.random() and optimize the time and space complexity.
 */
class Solution(private val n_row: Int, private val n_col: Int) {
    private val hashMap = mutableMapOf<Int, Int>()
    private var remaining = n_row * n_col
    fun flip(): IntArray {
        val random = Random.nextInt(remaining--)
        val value = hashMap.getOrDefault(random, random)
        hashMap[random] = hashMap.getOrDefault(remaining, remaining)
        return intArrayOf(value / n_col, value % n_col)
    }

    fun reset() {
        hashMap.clear()
        remaining = n_row * n_col
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(n_rows, n_cols)
 * var param_1 = obj.flip()
 * obj.reset()
 */