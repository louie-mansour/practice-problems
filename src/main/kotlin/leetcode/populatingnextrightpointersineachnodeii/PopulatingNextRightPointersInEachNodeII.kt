package leetcode.populatingnextrightpointersineachnodeii

/*
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
 */


// Option 1: In order traversal to visit nodes "in order". Note the depth of the node and the count at the depth
// then start another traversal until we find another node at the same height with a larger count. Otherwise, do nothing
// this can be recursive - doesn't require external data structures
// or it can be iterative, I believe this requires a stack

// Option 2: traverse in the order R, L, eval. Add the evaluated node to a hashmap with K = height and V = a reference to the Node
// If there is a node in hashmap, assign nodeBeingEvaluated.next to the node in the hashmap before updated the map.

// Option 3: traverse the tree "in order" and save it to a list
// I'm certain there is an algorithm to map an element to the others on the same depth
class PopulatingNextRightPointersInEachNodeII {

    fun connect(node: Node?): Node? {
        val nodeCache = mutableMapOf<Int, Node?>()
        dfsRLV(node, 0, nodeCache)
        return node
    }

    private fun dfsRLV(node: Node?, depth: Int, nodeCache: MutableMap<Int, Node?>) {
        if(node == null) return
        dfsRLV(node.right, depth + 1, nodeCache)
        dfsRLV(node.left, depth + 1, nodeCache)
        node.next = nodeCache.getOrDefault(depth, null)
        nodeCache[depth] = node
    }
}

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}