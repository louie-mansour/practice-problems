package leetcode.countandsay

/*
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

    countAndSay(1) = "1"
    countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 */

class Solution {
    fun countAndSay(n: Int): String {
        if(n == 1) {
            return "1"
        }
        var inputString = "1"
        for(i in 1 until n) {
            inputString = say(inputString, "")
        }
        return inputString
    }

    private fun say(input: String, sb: String): String {
        if(input.isBlank()) {
            return sb
        }
        val currentChar = input[0]
        var count = 0
        while(count < input.length && input[count] == currentChar) {
            count += 1
        }
        return count.toString() + currentChar + say(nextSubstring(input, count), sb)
    }

    private fun nextSubstring(input: String, nextIndex: Int): String {
        if(nextIndex >= input.length) {
            return ""
        }
        return input.substring(nextIndex)
    }
}