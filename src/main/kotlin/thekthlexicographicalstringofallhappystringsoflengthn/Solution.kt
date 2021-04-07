package thekthlexicographicalstringofallhappystringsoflengthn

/*
A happy string is a string that:

    consists only of letters of the set ['a', 'b', 'c'].
    s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).

For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are less than k happy strings of length n.
 */

class Solution {
    fun getHappyString(n: Int, k: Int): String {
        var happyStrings = listOf("")
        for(i in 0 until n) {
            happyStrings = newHappyStrings(happyStrings)
        }
        if(k <= happyStrings.size) {
            return happyStrings[k-1]
        }
        return ""
    }

    private fun newHappyStrings(happyStrings: List<String>): List<String> {
        val newHappyStrings = mutableListOf<String>()
        for(happyString in happyStrings) {
            for(letter in "abc") {
                if(isHappy(happyString, letter)) {
                    newHappyStrings.add("$happyString$letter")
                }
            }
        }
        return newHappyStrings
    }

    private fun isHappy(s: String, newChar: Char): Boolean {
        if(s.length == 0) {
            return true
        }
        if(s[s.length - 1] == newChar) {
            return false
        }
        return true
    }
}