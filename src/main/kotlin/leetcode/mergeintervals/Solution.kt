package leetcode.mergeintervals

/*
Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals, and return an array of the non-overlapping intervals
that cover all the intervals in the input.
 */

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if(intervals.isEmpty()) return intervals

        val sortedIntervals = intervals.sortedBy { it[0] }
        val mergedIntervals = mutableListOf<IntArray>()

        var currentMin = sortedIntervals[0][0]
        var currentMax = sortedIntervals[0][1]
        for(interval in sortedIntervals) {
            if(interval[0] <= currentMax) {
                currentMax = Math.max(currentMax, interval[1])
            } else {
                mergedIntervals.add(listOf(currentMin, currentMax).toIntArray())
                currentMin = interval[0]
                currentMax = interval[1]
            }
        }
        mergedIntervals.add(listOf(currentMin, currentMax).toIntArray())
        return mergedIntervals.toTypedArray()
    }
}