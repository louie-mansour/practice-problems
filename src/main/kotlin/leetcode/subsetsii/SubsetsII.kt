package leetcode.subsetsii

import org.junit.jupiter.api.Test

/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
 */
class SubsetsII {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val set = mutableSetOf<List<Int>>()
        permutations(emptyList(), nums.toList(), set)
        return set.map { it.toList() }.toList()
    }

    private fun permutations(prefix: List<Int>, suffix: List<Int>, sets: MutableSet<List<Int>>) {
        if(sets.contains(prefix.sorted())) return
        sets.add(prefix.sorted())
        for(i in suffix.indices) {
            permutations(prefix + listOf(suffix[i]), suffix.subList(0,i) + suffix.subList(i+1, suffix.size), sets)
        }
    }

    @Test
    fun test() {
        subsetsWithDup(listOf(1, 2, 2).toIntArray())
    }
}