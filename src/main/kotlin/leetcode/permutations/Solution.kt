package leetcode.permutations

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */

class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        if(nums.isEmpty()) {
            return listOf()
        }
        val permutations = mutableListOf<List<Int>>()
        permute(emptyList(), nums.toList(), permutations)
        return permutations
    }

    private fun permute(prefix: List<Int>, remainingNums: List<Int>, permutations: MutableList<List<Int>>) {
        if(remainingNums.isEmpty()) {
            permutations.add(prefix)
            return
        }

        for(i in remainingNums.indices) {
            permute(prefix + remainingNums[i], remainingNums.subList(0, i) + remainingNums.subList(i+1, remainingNums.size), permutations)
        }
    }
}