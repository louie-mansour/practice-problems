package leetcode.twosum

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
 */
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val memo = hashMapOf<Int, Int>()
        for(i in nums.indices) {
            val checkMemo = memo[target - nums[i]]
            if(checkMemo != null) {
                val result = IntArray(2)
                result[0] = checkMemo
                result[1] = i
                return result
            }
            memo[nums[i]] = i
        }
        return IntArray(0)
    }
}