package leetcode.surroundedregions

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SurroundedRegions {
    fun solve(board: Array<CharArray>): Array<CharArray> {
        if(board.size <= 1 || board[0].size <= 1) return board

        val perimeterEls = mutableListOf<Pair<Int, Int>>()
        (board.indices).map { perimeterEls.add(Pair(it, 0)) }
        (board[0].indices).map { perimeterEls.add(Pair(board.size - 1, it)) }
        (board.size - 1 downTo 0).map { perimeterEls.add(Pair(it, board[0].size - 1)) }
        (board[0].size - 1 downTo 0).map { perimeterEls.add(Pair(0, it)) }

        val cache = mutableSetOf<Pair<Int, Int>>()
        for(perimeterEl in perimeterEls) {
            if(board[perimeterEl.first][perimeterEl.second] == 'O') dfs(board, perimeterEl, cache)
        }

        for(i in board.indices) {
            for(j in board[0].indices) {
                if(!cache.contains(Pair(i, j))) board[i][j] = 'X'
            }
        }
        return board
    }

    private fun dfs(board: Array<CharArray>, el: Pair<Int, Int>, cache: MutableSet<Pair<Int, Int>>) {
        if(el.first < 0 || el.first >= board.size) return
        if(el.second < 0 || el.second >= board[0].size) return
        if(cache.contains(el)) return
        if(board[el.first][el.second] != 'O') return

        cache.add(el)
        dfs(board, Pair(el.first+1, el.second), cache)
        dfs(board, Pair(el.first, el.second+1), cache)
        dfs(board, Pair(el.first-1, el.second), cache)
        dfs(board, Pair(el.first, el.second-1), cache)
    }

    @Test
    fun test() {
        val grid = listOf(
            listOf('X', 'O'),
            listOf('O', 'X')
        ).map { it.toCharArray() }.toTypedArray()
        Assertions.assertEquals(grid, solve(grid))


        Assertions.assertEquals(
            listOf(
                listOf('X', 'O', 'X', 'O', 'X', 'O'),
                listOf('O', 'X', 'O', 'X', 'O', 'X'),
                listOf('X', 'O', 'X', 'O', 'X', 'O'),
                listOf('O', 'X', 'O', 'X', 'O', 'X')
            ).map { it.toCharArray() }.toTypedArray(),
            solve(listOf(
                listOf('X', 'O', 'X', 'O', 'X', 'O'),
                listOf('O', 'X', 'X', 'X', 'X', 'X'),
                listOf('X', 'X', 'X', 'X', 'X', 'O'),
                listOf('O', 'X', 'O', 'X', 'O', 'X'),
            ).map { it.toCharArray() }.toTypedArray()))
    }
}

// [["X","O","O","X","X","X","O","X","O","O"],["X","O","X","X","X","X","X","X","X","X"],["X","X","X","X","X","X","X","X","X","X"],["X","X","X","X","X","X","X","X","X","O"],["O","X","X","X","X","X","X","X","X","X"],["X","X","X","X","X","X","X","X","X","X"],["O","X","X","X","X","X","X","X","X","O"],["O","X","X","X","X","X","X","X","X","X"],["X","X","X","X","X","X","X","X","X","O"],["X","X","X","O","O","X","O","X","X","O"]]
// [["X","O","O","X","X","X","O","X","O","O"],["X","O","X","X","X","X","X","X","X","X"],["X","X","X","X","X","X","X","X","X","X"],["X","X","X","X","X","X","X","X","X","O"],["O","X","X","X","X","X","X","X","X","X"],["X","X","X","X","X","X","X","X","X","X"],["O","X","X","X","X","X","X","X","X","O"],["O","X","X","X","X","X","X","X","X","X"],["X","X","X","X","X","X","X","X","O","O"],["X","X","X","O","O","X","O","X","X","O"]]

// go around the perimeter of the board. at each element, if the value is 'X' continue
// if the value is 'O' then explore the area:
// option 1: Explore using DFS iterative: requires stack. No risk of SO
// option 2: Explore using DFS recursive: no external DS. Risk of SO errors (constraints on board imply this won't be an issue)
// option 3: Explore using BFS iterative: requires queue. NNo risk of SO
// time constraints and board constraints make me want to choose option 2:

// as we're exploring the area, note which elements have been visited
// option 1: mutate the board. Requires no additional structure. Less complex
// option 2: keep a cache of nodes. Requires additional data structure
// I think option 2 isn't hard and I like the idea of keeping the input immutable
