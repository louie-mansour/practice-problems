package leetcode.groupanagrams

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
 */

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        var strHistogram: MutableMap<Char, Int>
        return strs.groupBy { str ->
            strHistogram = mutableMapOf()
            str.forEach {
                strHistogram[it] = strHistogram[it]?.plus(1)?:1
            }
            strHistogram
        }.values.toList()
    }
}