package leetcode.shortedpathinabinarymatrix

import org.junit.jupiter.api.Assertions
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.test.Test
import kotlin.test.currentStackTrace

/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

    All the visited cells of the path are 0.
    All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).

The length of a clear path is the number of visited cells of this path.
 */
class ShortedPathInABinaryMatrix {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        // shortest path implies BFS
        // can either do bidirectional BFS or only use a single BFS
        // DFS is also possible but I think that on average it would require a longer runtime (the first soln BFS finds is a correct shortest solution. This isn't true for DFS)

        // There may be multiple implementations for BFS, the only one I know off the top off my head is an iterative approach using a queue
        val bfsQueue: Queue<Element> = LinkedList()
        if(grid[0][0] == 1) return -1
        bfsQueue.add(Element(0, 0, 1))

        while(bfsQueue.isNotEmpty()) {
            val currentEl = bfsQueue.poll()
            if(currentEl.x == grid.size-1 && currentEl.y == grid[0].size-1) return currentEl.dist

            val connections = findConnections(grid, currentEl)
            connections.forEach {
                bfsQueue.add(it)
                grid[it.x][it.y] = 1
            }
        }
        return -1
    }

    private fun findConnections(grid: Array<IntArray>, el: Element): List<Element> {
        val connections = mutableListOf<Element>()
        for(i in (el.x-1)..(el.x+1)) {
            if(i < 0 || i > grid.size-1) continue
            for(j in (el.y-1)..(el.y+1)) {
                if(j < 0 || j > grid[0].size-1) continue
                if(grid[i][j] == 0) {
                    connections.add(Element(i,j,el.dist+1))
                }
            }
        }
        return connections
    }

    private data class Element(val x: Int, val y: Int, val dist: Int)

    @Test
    fun test() {
        Assertions.assertEquals(2,
            shortestPathBinaryMatrix(listOf(
                listOf(0,1),
                listOf(1,0)
            ).map { it.toIntArray() }.toTypedArray())
        )

        Assertions.assertEquals(4,
            shortestPathBinaryMatrix(listOf(
                listOf(0,0,0),
                listOf(1,1,0),
                listOf(1,1,0)
            ).map { it.toIntArray() }.toTypedArray())
        )

        Assertions.assertEquals(-1,
            shortestPathBinaryMatrix(listOf(
                listOf(1,0,0),
                listOf(1,1,0),
                listOf(1,1,0)
            ).map { it.toIntArray() }.toTypedArray())
        )

        Assertions.assertEquals(-1,
            shortestPathBinaryMatrix(listOf(
                listOf(0,0,0),
                listOf(0,1,1),
                listOf(0,1,0)
            ).map { it.toIntArray() }.toTypedArray())
        )
    }
}