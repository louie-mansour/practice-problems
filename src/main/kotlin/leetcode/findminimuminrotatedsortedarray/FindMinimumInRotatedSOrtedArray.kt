package leetcode.findminimuminrotatedsortedarray

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.min

/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.
 */
class FindMinimumInRotatedSortedArray {
    fun findMin(nums: IntArray): Int {
        var minIdx = 0
        var maxIdx = nums.size - 1
        var midIdx: Int

        while(minIdx <= maxIdx) {
            midIdx = (minIdx + maxIdx) / 2

            if(nums[midIdx] > nums[maxIdx]) {
                minIdx = midIdx + 1
            } else if (nums[minIdx] > nums[midIdx]) {
                maxIdx = midIdx
            } else {
                return nums[minIdx]
            }
        }
        return nums[minIdx]
    }

    @Test
    fun findMinTest() {
        Assertions.assertEquals(findMin(listOf(3, 4, 5, 1, 2).toIntArray()), 1)
        Assertions.assertEquals(findMin(listOf(4, 5, 6, 7, 0, 1, 2).toIntArray()), 0)
        Assertions.assertEquals(findMin(listOf(11, 13, 15, 17).toIntArray()), 11)
        Assertions.assertEquals(findMin(listOf(1).toIntArray()), 1)
        Assertions.assertEquals(findMin(listOf(3, 1, 2).toIntArray()), 1)
        Assertions.assertEquals(findMin(listOf(2, 3, 1).toIntArray()), 1)
    }
}