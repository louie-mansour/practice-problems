package leetcode.lettercombinationsofaphonenumber

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */

class Solution {
    fun letterCombinations(digits: String): List<String> {
        if(digits == "") { return emptyList() }
        var letterCombinations = mutableListOf("")
        for(digit in digits) {
            letterCombinations = addLetterCombinations(digit, letterCombinations)
        }
        return letterCombinations
    }

    private fun addLetterCombinations(digit: Char, inputCombinations: List<String>): MutableList<String> {
        val outputCombinations = mutableListOf<String>()
        for(inputCombination in inputCombinations) {
            for(letter in lettersForDigit(digit)) {
                outputCombinations.add("$inputCombination$letter")
            }
        }
        return outputCombinations
    }

    private fun lettersForDigit(digit: Char): List<Char> {
        return when(digit) {
            '2' -> listOf('a', 'b', 'c')
            '3' -> listOf('d', 'e', 'f')
            '4' -> listOf('g', 'h', 'i')
            '5' -> listOf('j', 'k', 'l')
            '6' -> listOf('m', 'n', 'o')
            '7' -> listOf('p', 'q', 'r', 's')
            '8' -> listOf('t', 'u', 'v')
            '9' -> listOf('w', 'x', 'y', 'z')
            else -> emptyList()
        }
    }
}