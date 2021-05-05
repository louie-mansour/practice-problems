package leetcode.runningSumOf1dArray

/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.
 */

class Solution {
    fun runningSum(nums: IntArray): IntArray {
        val runningNums = IntArray(nums.size)
        var runningSum = 0
        for(i in nums.indices) {
            runningSum += nums[i]
            runningNums[i] = runningSum
        }
        return runningNums
    }
}