package leetcode.subarrayproductslessthank

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/*
Given an array of integers nums and an integer k,
return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 */
class SubArrayProductsLessThanK {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        var count = 0
        for(i in nums.indices) {
            var runningMultiples = 1
            var j = i
            while(runningMultiples < k && j < nums.size) {
                runningMultiples *= nums[j]
                if(runningMultiples < k) count += 1
                j++
            }
        }
        return count
    }

    @Test
    fun test() {
        Assertions.assertEquals(8, numSubarrayProductLessThanK(listOf(10,5,2,6).toIntArray(), 100))
        Assertions.assertEquals(0, numSubarrayProductLessThanK(listOf(1,2,3).toIntArray(), 0))
    }
}