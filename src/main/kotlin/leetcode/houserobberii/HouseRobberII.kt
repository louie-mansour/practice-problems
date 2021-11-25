package leetcode.houserobberii

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class HouseRobberII {
    fun rob(nums: IntArray): Int {
        if(nums.size == 1) return nums[0]
        val memo0 = mutableMapOf<Int, Int>()
        val memo1 = mutableMapOf<Int, Int>()
        return Math.max(Math.max(
            rob(nums, nums.lastIndex, memo1, 1),
            rob(nums, nums.lastIndex - 1, memo0, 0)),
            rob(nums, nums.lastIndex - 2, memo0, 0)
        )
    }

    private fun rob(nums: IntArray, houseNumber: Int, memo: MutableMap<Int, Int>, firstHouseIndex: Int): Int {
        if(houseNumber < firstHouseIndex) return 0
        if(houseNumber <= 1) memo[houseNumber] = nums[houseNumber]

        if(memo.contains(houseNumber)) return memo[houseNumber]?: 0

        memo[houseNumber] = Math.max(
            rob(nums,houseNumber - 2, memo, firstHouseIndex),
            rob(nums, houseNumber - 3,  memo, firstHouseIndex)
        ) + nums[houseNumber]
        return memo[houseNumber]?: 0
    }

    @Test
    fun test() {
        Assertions.assertEquals(340, rob(intArrayOf(200, 3, 140, 20, 10)))
    }
}