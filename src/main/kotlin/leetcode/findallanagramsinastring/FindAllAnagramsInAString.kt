package leetcode.findallanagramsinastring

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
class FindAllAnagramsInAString {
    fun findAnagrams(s: String, p: String): List<Int> {
        val anagramIndices = mutableListOf<Int>()
        val pHisto = genHisto(p)
        for(i in 0..(s.length - p.length)) {
            if(pHisto == genHisto(s.substring(i, i + p.length))) {
                anagramIndices.add(i)
            }
        }
        return anagramIndices
    }

    private fun genHisto(s: String): Map<Char, Int> {
        val histo = mutableMapOf<Char, Int>()
        s.map { histo[it] = histo[it]?.plus(1)?: 0 }
        return histo
    }

    @Test
    fun test() {
        Assertions.assertEquals(listOf(0, 6), findAnagrams("cbaebabacd", "abc"))
        Assertions.assertEquals(listOf(0, 1, 2), findAnagrams("abab", "ab"))
    }
}