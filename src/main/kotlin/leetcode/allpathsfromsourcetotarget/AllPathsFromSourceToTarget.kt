package leetcode.allpathsfromsourcetotarget

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/*
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 */

// Likely looking and BFS or DFS
// option 1: BFS - requires external queue - usually good for finding "shortest" solution but is also able to find all solutions
// option 2: Iterative DFS - requires external stack - can find all solutions
// option 3: recursive DFS - no additional data structures - can find all solutions

// potential optimization be breaking it into sub problems - can leave that for later. First let's solve it simply
class AllPathsFromSourceToTarget {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val completePaths = mutableListOf<List<Int>>()
        dfs(graph, mutableListOf(0), graph.size - 1, completePaths)
        return completePaths
    }

    private fun dfs(graph: Array<IntArray>, currentPath: MutableList<Int>, targetNode: Int, completePaths: MutableList<List<Int>>)  {
        if(currentPath.last() == targetNode) {
            completePaths.add(currentPath)
            return
        }

        for(connectedNode in graph[currentPath.last()]) {
            dfs(graph, (currentPath + connectedNode) as MutableList<Int>, targetNode, completePaths)
        }
    }

    @Test
    fun test() {
        Assertions.assertTrue(allPathsSourceTarget(listOf(
            listOf(1, 2),
            listOf(3),
            listOf(3),
            listOf()
        ).map { it.toIntArray() }.toTypedArray()) == listOf(listOf(0, 1, 3), listOf(0, 2, 3)))

        Assertions.assertTrue(allPathsSourceTarget(listOf(
            listOf(4, 3, 1),
            listOf(3, 2, 4),
            listOf(3),
            listOf(4),
            listOf()
        ).map { it.toIntArray() }.toTypedArray()) == listOf(listOf(0, 4), listOf(0, 3, 4), listOf(0, 1, 3, 4), listOf(0, 1, 2, 3, 4), listOf(0, 1, 4)))
    }
}