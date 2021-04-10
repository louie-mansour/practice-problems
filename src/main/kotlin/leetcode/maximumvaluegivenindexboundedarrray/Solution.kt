package leetcode.maximumvaluegivenindexboundedarrray

/*
You are given three positive integers n, index and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:

    nums.length == n
    nums[i] is a positive integer where 0 <= i < n.
    abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
    The sum of all the elements of nums does not exceed maxSum.
    nums[index] is maximized.

Return nums[index] of the constructed array.

Note that abs(x) equals x if x >= 0, and -x otherwise.
 */

class Solution {
    fun maxValue(n: Int, index: Int, maxSum: Int): Int {
        val leftHistogramLength = index + 1
        val rightHistogramLength = n - index
        var leftHistogramSum = 0
        var rightHistogramSum = 0
        var target = 0
        while(leftHistogramSum + rightHistogramSum <= maxSum) {
            leftHistogramSum = boundedNaturalNumbersSum(target, target - leftHistogramLength)
            rightHistogramSum = boundedNaturalNumbersSum(target - 1, target - rightHistogramLength)
            target += 1
        }
        return target - 2
    }

    private fun boundedNaturalNumbersSum(upperBound: Int, lowerBound: Int): Int {
        return naturalNumbersSum(upperBound) - naturalNumbersSum(lowerBound)
    }

    private fun naturalNumbersSum(n: Int): Int {
        if(n <= 0) return 0
        return n*(n+1)/2
    }
}