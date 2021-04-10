package leetcode.partitiontokequalsumsubsets


/*
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 */

class Solution {

    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        var k = k
        val sum = nums.sum()
        if (sum % k > 0) return false
        val target = sum / k
        nums.sort()
        var position = nums.size - 1
        if (nums[position] > target) return false
        while (position >= 0 && nums[position] == target) {
            position--
            k--
        }
        return search(IntArray(k), position, nums, target)
    }

    private fun search(groups: IntArray, position: Int, nums: IntArray, target: Int): Boolean {
        var position = position
        if (position < 0) return true
        val valueOfpreviousPosition = nums[position--]
        for (i in groups.indices) {
            if (groups[i] + valueOfpreviousPosition <= target) {
                groups[i] += valueOfpreviousPosition
                if (search(groups, position, nums, target)) return true
                groups[i] -= valueOfpreviousPosition
            }
            if (groups[i] == 0) break
        }
        return false
    }
}