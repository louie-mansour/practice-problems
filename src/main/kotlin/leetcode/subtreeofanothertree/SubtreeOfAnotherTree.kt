package leetcode.subtreeofanothertree

/*
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 */
class SubtreeOfAnotherTree {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if(root == null || subRoot == null) return false
        return dfs(root, subRoot)
    }

    private fun dfs(treeNode: TreeNode, subRoot: TreeNode): Boolean {
        if(isEqual(treeNode, subRoot)) return true

        if(treeNode.left != null && dfs(treeNode.left!!, subRoot)) return true
        if(treeNode.right != null && dfs(treeNode.right!!, subRoot)) return true
        return false
    }

    private fun isEqual(treeNode: TreeNode, subTreeNode: TreeNode): Boolean {
        if(treeNode.`val` != subTreeNode.`val`) return false
        if(treeNode.left?.`val` != subTreeNode.left?.`val`) return false
        if(treeNode.right?.`val` != subTreeNode.right?.`val`) return false

        var isMatch = true
        if(treeNode.left != null && subTreeNode.left != null) {
            isMatch = isMatch && isEqual(treeNode.left!!, subTreeNode.left!!)
        }

        if(treeNode.right != null && subTreeNode.right != null) {
            isMatch = isMatch && isEqual(treeNode.right!!, subTreeNode.right!!)
        }
        return isMatch
    }
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
