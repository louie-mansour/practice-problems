package `3sum`

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val solutionSet = mutableSetOf<List<Int>>()
        val memoSet = mutableSetOf<Int>()
        for(i in nums.indices) {
            for(j in i+1 until nums.size) {
                if(memoSet.contains(-nums[j])) {
                    solutionSet.add(listOf(nums[i], nums[j], -nums[i]-nums[j]).sorted())
                }
                memoSet.add(nums[i] + nums[j])
            }
            memoSet.clear()
        }
        return solutionSet.toList()
    }
}