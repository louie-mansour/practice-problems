package longestpalindromicsubstring

/*
Given a string s, return the longest palindromic substring in s.
 */
class Solution {
    fun longestPalindrome(s: String): String {
        var longestPalindrome = ""
        var substring = ""
        for(i in s.indices) {
            for(j in i until s.length) {
                substring = s.substring(i, j + 1)
                if(isPalindrome(substring) && substring.length > longestPalindrome.length) {
                    longestPalindrome = substring
                }
            }
        }
        return longestPalindrome
    }

    private fun isPalindrome(s: String): Boolean {
        for(i in 0 until (s.length/2)) {
            if(s[i] != s[s.length -1 - i]) {
                return false
            }
        }
        return true
    }
}