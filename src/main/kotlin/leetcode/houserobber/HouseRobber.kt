package leetcode.houserobber

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class HouseRobber {
    fun rob(nums: IntArray): Int {
        val memo = mutableMapOf<Int, Int>()
        rob(nums, nums.lastIndex, memo)
        return Math.max(rob(nums, nums.lastIndex, memo), rob(nums, nums.lastIndex - 1, memo))
    }

    private fun rob(nums: IntArray, houseNumber: Int, memo: MutableMap<Int, Int>): Int {
        if(houseNumber < 0) return 0
        if(houseNumber <= 1) memo[houseNumber] = nums[houseNumber]

        if(memo.contains(houseNumber)) return memo[houseNumber]?: 0

        memo[houseNumber] = Math.max(rob(nums,houseNumber - 2, memo), rob(nums, houseNumber - 3,  memo)) + nums[houseNumber]
        return memo[houseNumber]?: 0
    }

    @Test
    fun test() {
        Assertions.assertEquals(12, rob(intArrayOf(2, 7, 9, 3, 1)))
    }
}