package leetcode.validtrianglenumber;

/*
Given an array consists of non-negative integers,
your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 */
class Solution {
    fun triangleNumber(nums: IntArray): Int {
        var count = 0
        for(i in 0 until nums.size) {
            for(j in (i+1) until nums.size) {
                for(k in (j+1) until nums.size) {
                    if(isTriangleNumber(nums[i], nums[j], nums[k])) {
                        count++
                    }
                }
            }
        }
        return count
    }

    private fun isTriangleNumber(n0: Int, n1: Int, n2: Int): Boolean {
        return n0 > 0 && n1 > 0 && n2 > 0
                && n0 < n1 + n2
                && n1 < n0 + n2
                && n2 < n0 + n1
    }
}
