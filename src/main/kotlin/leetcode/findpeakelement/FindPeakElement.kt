package leetcode.findpeakelement

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/*
A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.
 */
class FindPeakElement {
    fun findPeakElement(nums: IntArray): Int {
        // Option 1: Recursive binary search: has immutable values. Is an elegant solution with fewer variable assignments
        // Best suited to a language that supports tail recursion. Best suited to functional programming. If the recursive call isn't a tail call, could cause issues

        // Option 2: Iterative binary search: has mutable values. Solution is relatively easy to understand but has many variable reassignments
        // Best suited to a language that doesn't support tail recursion. Suited for non-FP code. Doesn't require a working tail-recursion call

        // Choosing Option 2 for the following reasons:
        // 1. Easier to extend without having to maintain a tail-recursive call
        // 2. It is not required that this problem is solved using FP

        if(nums.size == 1) return 0

        var minIdx = 0
        var maxIdx = nums.size - 1
        var midIdx: Int

        while(minIdx <= maxIdx) {
            midIdx = (minIdx + maxIdx) / 2
            if(isPeak(nums, midIdx)) {
                return midIdx
            } else if(isRightIncreasing(nums, midIdx)) {
                minIdx = midIdx + 1
            } else {
                maxIdx = midIdx - 1
            }
        }

        return -1
    }

    private fun isPeak(nums: IntArray, idx: Int): Boolean {
        return idx == 0 && nums[idx + 1] < nums[idx]
                || idx == nums.size - 1 && nums[idx - 1] < nums[idx]
                || idx != 0 && idx != nums.size - 1 && nums[idx - 1] < nums[idx] && nums[idx + 1] < nums[idx]
    }

    private fun isRightIncreasing(nums: IntArray, idx: Int): Boolean {
        return idx != nums.size - 1 && nums[idx + 1] > nums[idx]
    }

    private fun isLeftIncreasing(nums: IntArray, idx: Int): Boolean {
        return idx != 0 && nums[idx - 1] > nums[idx]
    }

    @Test
    fun test() {
        val l1231 = listOf(1, 2, 3, 1).toIntArray()
        val r1231 = findPeakElement(l1231)

        Assertions.assertTrue(!isRightIncreasing(l1231, r1231) && !isLeftIncreasing(l1231, r1231))

        val l1213564 = listOf(1, 2, 1, 3, 5, 6, 4).toIntArray()
        val r1213564 = findPeakElement(l1213564)

        Assertions.assertTrue(!isRightIncreasing(l1213564, r1213564) && !isLeftIncreasing(l1213564, r1213564))

        Assertions.assertEquals(findPeakElement(listOf(1).toIntArray()), 0)
        Assertions.assertEquals(findPeakElement(listOf(1, 2).toIntArray()), 1)
    }
}
