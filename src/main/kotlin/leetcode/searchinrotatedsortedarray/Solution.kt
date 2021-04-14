package leetcode.searchinrotatedsortedarray

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val pivotIndex = binarySearchForPivotIndex(nums)
        return binarySearchForTarget(nums, pivotIndex, target)
    }

    private fun binarySearchForPivotIndex(nums: IntArray): Int {
        var iLower = 0
        var iUpper = nums.size-1
        var iBisect: Int
        while(true) {
            iBisect = (iLower + iUpper) / 2
            if(iLower == iBisect || iUpper == iBisect) {
                return iBisect
            }

            if(nums[iLower] > nums[iBisect]) {
                iUpper = iBisect
            } else if(nums[iUpper] < nums[iBisect]) {
                iLower = iBisect
            } else {
                return 0
            }
        }
    }

    private fun binarySearchForTarget(nums: IntArray, pivot: Int, target: Int): Int {
        var iLower = 0
        var iUpper = nums.size-1
        var iBisect: Int
        var pivotedBisect: Int
        if(nums[transform(0, pivot, nums.size)] == target) return transform(0, pivot, nums.size)
        if(nums[transform(nums.size-1, pivot, nums.size)] == target) return transform(nums.size-1, pivot, nums.size)

        while(true) {
            if(iUpper < iLower) return -1

            iBisect = (iLower + iUpper + 1) / 2
            pivotedBisect = transform(iBisect, pivot, nums.size)
            if(nums[pivotedBisect] < target) {
                iLower = iBisect + 1
            } else if(nums[pivotedBisect] > target) {
                iUpper = iBisect - 1
            } else {
                return pivotedBisect
            }
        }
    }

    private fun transform(index: Int, pivot: Int, size: Int): Int {
        return (index + pivot) % size
    }
}