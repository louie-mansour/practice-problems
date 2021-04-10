package leetcode.removealladjacentduplicatesinstring

/*
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.
We repeatedly make k duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made.
It is guaranteed that the answer is unique.
 */
class Solution {
    fun removeDuplicates(s: String, k: Int): String {
        var isRemovedDuplicates = true
        var currentString = s

        while(isRemovedDuplicates) {
            isRemovedDuplicates = false
           for(i in 0..currentString.length) {
               if(i + k <= currentString.length && isAllDuplicates(currentString.substring(i, i + k), k)) {
                   currentString = currentString.substring(0, i) + currentString.substring(i + k)
                   isRemovedDuplicates = true
               }
           }
        }
        return currentString
    }

    private fun isAllDuplicates(substring: String, k: Int): Boolean {
        return substring.length == k && substring.all { it == substring[0] }
    }
}