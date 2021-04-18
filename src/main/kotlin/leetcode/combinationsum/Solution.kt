package leetcode.combinationsum

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different.
It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */

class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val set = mutableSetOf<List<Int>>()
        combinationSum(emptyList(), candidates, target, set)
        return set.toList()
    }

    private fun combinationSum(prefix: List<Int>, candidates: IntArray, target: Int, set: MutableSet<List<Int>>): Unit {
        if(prefix.sum() > target) {
            return
        }
        if(prefix.sum() == target) {
            set.add(prefix.sorted())
            return
        }
        for(candidate in candidates) {
            combinationSum(prefix + candidate, candidates, target, set)
        }
    }
}