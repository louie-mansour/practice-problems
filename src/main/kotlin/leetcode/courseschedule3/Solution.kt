package leetcode.courseschedule3

import java.util.*
import java.util.PriorityQueue

import java.util.Arrays




/*
There are n different online courses numbered from 1 to n.
You are given an array courses where courses[i] = [durationi, lastDayi] indicate that the ith course should be taken
continuously for durationi days and must be finished before or on lastDayi.
You will start on the 1st day and you cannot take two or more courses simultaneously.

Return the maximum number of courses that you can take.
 */

class Solution {
    fun scheduleCourse(courses: Array<IntArray>): Int {
        Arrays.sort(courses) { a: IntArray, b: IntArray -> a[1] - b[1] }
        val queue = PriorityQueue { a: Int, b: Int -> b - a }
        var time = 0
        for (c in courses) {
            if (time + c[0] <= c[1]) {
                queue.offer(c[0])
                time += c[0]
            } else if (!queue.isEmpty() && queue.peek() > c[0]) {
                time += c[0] - queue.poll()
                queue.offer(c[0])
            }
        }
        return queue.size
    }
}