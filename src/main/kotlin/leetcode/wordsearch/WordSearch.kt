package leetcode.wordsearch

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells
 where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */

// ALGO
// option 1: iterative BFS - requires a queue
// option 2: recusrive BFS - I hear it's difficult and I don't know it off the top of my head
// option 3: iterative DFS - requires a stack
// option 4: recursive DFS - easier to implement, however we must not exceed the limit of frames on the callstack (tail recursive?)

// BOOKKEEPING
// option 1: use a set to determine if I've visited an element in a specific run
// option 2: mutate the board

// BACKTRACKING
// the moment we know finding the word isn't possible in a run, we can stop the search for that run early
class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        if(word == "") return true
        val charSet = board.flatMap { it.toList() }.toSet()
        if(word.any { !charSet.contains(it) }) return false
        for(i in board.indices) {
            for(j in board[0].indices) {
                if(dfs(board, word, mutableListOf(Pair(i, j)))) {
                    return true
                }
            }
        }
        return false
    }

    private fun dfs(board: Array<CharArray>, word: String, currWordIndices: List<Pair<Int, Int>>): Boolean {
        val currCharIndex = currWordIndices.last()
        if(currCharIndex.first < 0 || currCharIndex.first >= board.size) return false
        if(currCharIndex.second < 0 || currCharIndex.second >= board[0].size) return false
        val currentWord = currWordIndices.map { board[it.first][it.second] }.joinToString("")
        if(currWordIndices.count { it.first == currCharIndex.first && it.second == currCharIndex.second } > 1) return false
        if(!word.startsWith(currentWord)) return false
        
        if(word == currentWord) return true

        return dfs(board, word, currWordIndices + Pair(currCharIndex.first + 1,currCharIndex.second))
                || dfs(board, word, currWordIndices + Pair(currCharIndex.first,currCharIndex.second + 1))
                || dfs(board, word, currWordIndices + Pair(currCharIndex.first - 1,currCharIndex.second))
                || dfs(board, word, currWordIndices + Pair(currCharIndex.first,currCharIndex.second - 1))
    }

    @Test
    fun test() {
        Assertions.assertTrue(exist(listOf("ABCE", "SFCS", "ADEE").map { it.toCharArray() }.toTypedArray(), "SEE"))
    }
}