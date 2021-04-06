package longestsubstringwithoutrepeatingcharacters

/*
Given a string s, find the length of the longest substring without repeating characters.
 */
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var longestSubstringLength = 0
        var currentSubstringLength = 0
        val lettersSet = mutableSetOf<Char>()
        for(i in s.indices) {
            for(j in i until (s.length)) {
                if(lettersSet.contains(s[j])) { break }
                currentSubstringLength += 1
                if(currentSubstringLength > longestSubstringLength) { longestSubstringLength = currentSubstringLength }
                lettersSet.add(s[j])
            }
            lettersSet.clear()
            currentSubstringLength = 0
        }
        return longestSubstringLength
    }
}