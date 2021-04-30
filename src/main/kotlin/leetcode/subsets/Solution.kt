package leetcode.subsets

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
 */

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val memo = mutableSetOf<Set<Int>>()
        subsets(emptyList(), nums.toList(), memo)
        return memo.map { it.toList() }
    }

    private fun subsets(prefix: List<Int>, remainingNums: List<Int>, memo: MutableSet<Set<Int>>) {
        memo.add(prefix.toSet())

        for(i in remainingNums.indices) {
            subsets(prefix + remainingNums[i], remainingNums.subList(i + 1, remainingNums.size), memo)
        }
    }
}