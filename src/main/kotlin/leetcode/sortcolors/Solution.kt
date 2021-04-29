package leetcode.sortcolors

/*
Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 */

class Solution {
    fun sortColors(nums: IntArray) {
        val memo = mutableListOf(0, 0, 0)
        var pos = 0
        nums.forEach { memo[it] = memo[it] + 1 }
        memo.indices.forEach { index ->
            (0 until memo[index]).forEach { _ ->
                nums[pos] = index
                pos += 1
            }
        }
    }
}