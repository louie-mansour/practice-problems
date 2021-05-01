package leetcode.removeduplicatesfromsortedarray

/*
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.
 */

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if(nums.isEmpty()) return 0

        var iter0 = 0
        var iter1 = 0
        var prevVal: Int?= null
        var count = 0

        while(iter0 < nums.size) {
            if(nums[iter0] == prevVal) {
                count += 1
            } else  {
                count = 1
            }

            prevVal = nums[iter0]

            if(count <= 2) {
                nums[iter1] = nums[iter0]
                iter0 += 1
                iter1 += 1
            } else {
                iter0 += 1
            }
        }
        return iter1
    }
}