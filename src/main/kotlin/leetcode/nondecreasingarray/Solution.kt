package leetcode.nondecreasingarray

/*
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 */

class Solution {
    fun checkPossibility(nums: IntArray): Boolean {
        return checkPossibilities(nums, 0, 1)
    }

    private fun checkPossibilities(nums: IntArray, pos: Int, maxEdits: Int): Boolean {
        if(maxEdits < 0) {
            return false
        }
        var i = pos
        var prev = Int.MIN_VALUE
        while(i < nums.size) {
            if(nums[i] < prev) {
                val hiNums = nums.clone()
                if(i - 2 >= 0) {
                    hiNums[i - 1] = nums[i - 2]
                } else {
                    hiNums[i - 1] = Int.MIN_VALUE
                }
                val lowNums = nums.clone()
                lowNums[i] = nums[i - 1]
                return checkPossibilities(hiNums, i - 1, maxEdits - 1) || checkPossibilities(lowNums, i, maxEdits - 1)
            }
            prev = nums[i]
            i += 1
        }
        return true
    }
}