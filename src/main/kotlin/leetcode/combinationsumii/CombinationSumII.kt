package leetcode.combinationsumii

import org.junit.jupiter.api.Test

/*
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
 */
class CombinationSumII {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val set = mutableSetOf<List<Int>>()
        val visitedSet = mutableSetOf<List<Int>>()

        permutations(emptyList(), candidates.toList(), target, set, visitedSet)

        return set.toList()
    }

    private fun permutations(suffix: List<Int>, prefix: List<Int>, target: Int, set: MutableSet<List<Int>>, visitedSet: MutableSet<List<Int>>) {
        val sortedSuffix = suffix.sorted()
        val sum = suffix.sum()
        if(visitedSet.contains(sortedSuffix)) return
        visitedSet.add(sortedSuffix)
        if(sum > target) return
        if(sum == target) { set.add(sortedSuffix); return }
        
        for(i in prefix.indices) {
            permutations(suffix + prefix[i], prefix.subList(0, i) + prefix.subList(i + 1, prefix.size), target, set, visitedSet)
        }
    }

    @Test
    fun test() {
        combinationSum2(listOf(10, 1, 2, 7, 6, 1, 5).toIntArray(), 8)
    }
}

// we're looking at permutations here
// permutations can be completed recursively - they can also be completed iteratively
// I'm more familiar with the recursive solution (downside: will add frames to the call stack) (upside: I can code it faster)