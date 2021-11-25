package leetcode.firstandlastpositionofelementsinsortedarray

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/*
Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
 */
class FirstAndLastElementsInSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        // option 1: recursive approach (recursion is fun - but only if it's tail recursion)
        // option 2: iterative approach (may not be as clean, but it's also less fragile)
        if(nums.isEmpty()) return listOf(-1, -1).toIntArray()

        return listOf(binSearchMin(nums, target), binSearchMax(nums, target)).toIntArray()

    }

    private fun binSearchMin(nums: IntArray, target: Int): Int {
        var startIdx = 0
        var endIdx = nums.size - 1
        var evalIdx: Int

        while(startIdx <= endIdx) {
            evalIdx = (startIdx + endIdx) / 2
            if(nums[evalIdx] == target && (evalIdx == startIdx || nums[evalIdx - 1] != target)) {
                return evalIdx
            } else if(nums[evalIdx] < target) {
                startIdx = evalIdx + 1
            } else {
                endIdx = evalIdx - 1
            }
        }
        return -1
    }

    private fun binSearchMax(nums: IntArray, target: Int): Int {
        var startIdx = 0
        var endIdx = nums.size - 1
        var evalIdx: Int

        while(startIdx <= endIdx) {
            evalIdx = (startIdx + endIdx) / 2
            if(nums[evalIdx] == target && (evalIdx == endIdx || nums[evalIdx + 1] != target)) {
                return evalIdx
            } else if(nums[evalIdx] > target) {
                endIdx = evalIdx - 1
            } else {
                startIdx = evalIdx + 1
            }
        }
        return -1
    }

    @Test
    fun testExamples() {
        Assertions.assertEquals(searchRange(listOf(5,7,7,8,8,10).toIntArray(), 8)[0], 3)
        Assertions.assertEquals(searchRange(listOf(5,7,7,8,8,10).toIntArray(), 8)[1], 4)

        Assertions.assertEquals(searchRange(listOf(5,7,7,8,8,10).toIntArray(), 6)[0], -1)
        Assertions.assertEquals(searchRange(listOf(5,7,7,8,8,10).toIntArray(), 6)[1], -1)

        Assertions.assertEquals(searchRange(listOf<Int>().toIntArray(), 0)[0], -1)
        Assertions.assertEquals(searchRange(listOf<Int>().toIntArray(), 0)[1], -1)

        Assertions.assertEquals(searchRange(listOf(2,2).toIntArray(), 2)[0], 0)
        Assertions.assertEquals(searchRange(listOf(2,2).toIntArray(), 2)[1], 1)
    }
}