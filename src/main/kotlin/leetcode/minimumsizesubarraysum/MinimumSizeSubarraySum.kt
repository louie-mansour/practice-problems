package leetcode.minimumsizesubarraysum

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.min

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray
[numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 */
class MinimumSizeSubarraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var minimumSize = Int.MAX_VALUE
        for(i in nums.indices) {
            var j = i
            var currentSize = 0
            while(j < nums.size && currentSize < target) {
                currentSize += nums[j]
                j++
            }
            if(currentSize >= target && j - i < minimumSize) {
                minimumSize = j - i
            }
        }
        return if(minimumSize == Int.MAX_VALUE) 0 else minimumSize
    }

    @Test
    fun test() {
        Assertions.assertEquals(2, minSubArrayLen(7, listOf(2,3,1,2,4,3).toIntArray()))
        Assertions.assertEquals(1, minSubArrayLen(4, listOf(1,4,4).toIntArray()))
        Assertions.assertEquals(0, minSubArrayLen(11, listOf(1,1,1,1,1,1,1,1,1,1).toIntArray()))
    }
}