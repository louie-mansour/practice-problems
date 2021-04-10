package leetcode.`3sumclosest`

/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.
 */

class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var closestToTarget = nums[0] + nums[1] + nums[2]
        var sum: Int
        for(i in nums.indices) {
            for(j in i+1 until nums.size) {
                for(k in j+1 until nums.size) {
                    sum = nums[i] + nums[j] + nums[k]
                    if(Math.abs(sum - target) < Math.abs( closestToTarget - target)) {
                        closestToTarget = sum
                    }
                }
            }
        }
        return closestToTarget
    }
}