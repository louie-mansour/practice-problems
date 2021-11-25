package leetcode.jumpgame

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        return canJump(nums, 0, mutableSetOf())
    }

    private fun canJump(nums: IntArray, idx: Int, memo: MutableSet<Int>): Boolean {
        for(i in nums[idx] downTo 1) {
            if(idx + i >= nums.size - 1) return true
            if(memo.contains(idx + i)) return false
            if(canJump(nums, idx + i, memo)) return true
        }
        memo.add(idx)
        return false
    }

    @Test
    fun test() {
        Assertions.assertTrue(canJump(listOf(2, 3, 1, 1, 4).toIntArray()))
        Assertions.assertFalse(canJump(listOf(3, 2, 1, 0, 4).toIntArray()))
        Assertions.assertTrue(canJump(listOf(2, 0, 0).toIntArray()))
        Assertions.assertTrue(canJump(listOf(0).toIntArray()))
        Assertions.assertTrue(canJump(listOf(2, 5, 0, 0).toIntArray()))
    }
}