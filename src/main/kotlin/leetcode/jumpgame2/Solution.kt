package leetcode.jumpgame2

/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
You can assume that you can always reach the last index.
 */

class Solution {
    fun jump(nums: IntArray): Int {
        return jump(nums, 1, mutableMapOf(0 to 0))
    }

    private fun jump(nums: IntArray, pos: Int, memo: MutableMap<Int, Int>): Int {
        if(pos == nums.size) {
            return memo[pos - 1]!!
        }
        var minJumps = Int.MAX_VALUE
        for(i in 0 until pos) {
            if(i + nums[i] >= pos && memo[i]!! + 1 < minJumps) {
                minJumps = memo[i]!! + 1
            }
        }
        memo[pos] = minJumps
        return jump(nums, pos + 1, memo)
    }
}