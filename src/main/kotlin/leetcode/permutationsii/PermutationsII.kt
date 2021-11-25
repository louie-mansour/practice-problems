package leetcode.permutationsii

import org.junit.jupiter.api.Test

/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 */
class PermutationsII {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val set = mutableSetOf<List<Int>>()
        val visitedSet = mutableSetOf<List<Int>>()
        permutations(emptyList(), nums.toList(), set, visitedSet)
        return set.toList()
    }

    private fun permutations(suffix: List<Int>, prefix: List<Int>, set: MutableSet<List<Int>>, visitedSet: MutableSet<List<Int>>) {
        if(visitedSet.contains(suffix)) return
        visitedSet.add(suffix)

        if(prefix.isEmpty()) set.add(suffix)

        for(i in prefix.indices) {
            permutations(suffix + prefix[i], prefix.subList(0, i) + prefix.subList(i + 1, prefix.size), set, visitedSet)
        }
    }

    @Test
    fun test() {
        permuteUnique(listOf(1, 2, 3).toIntArray())
    }
}

// permutations can be implemented recursively - largest downside here is that we may exceed the max stack size
// I *think* they can also be implemented iteratively using a stack, but I'm not as familiar with that approach
// there is a time limit on this question - I'm going to take the recusrive approach
// with the recusrive approach will I be recalculating? I can keep this in mind while solving