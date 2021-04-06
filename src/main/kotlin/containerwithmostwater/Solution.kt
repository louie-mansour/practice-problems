package containerwithmostwater

import kotlin.math.max

/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.
 */

class Solution {
    fun maxArea(heights: IntArray): Int {
        val memo = mutableMapOf<Int, Int>()
        var maxArea = 0
        var largestRunning = 0
        var currentHeight: Int
        var currentArea: Int
        for(i in heights.indices) {
            currentHeight = heights[i]

            for(pair in memo) {
                currentArea = minOf(pair.value, currentHeight) * (i - pair.key)
                if(currentArea > maxArea) {
                    maxArea = currentArea
                }
            }

            if(currentHeight > largestRunning) {
                largestRunning = currentHeight
                memo[i] = currentHeight
            }
        }
        return maxArea
    }
}