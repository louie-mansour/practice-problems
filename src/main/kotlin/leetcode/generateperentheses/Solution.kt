package leetcode.generateperentheses

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Output
["(((())))","()((()))","((()))()","(()(()))","()()(())","()(())()","((())())","(())()()","((()()))","()(()())","(()())()","(()()())","()()()()"]
Expected
["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
 */
class Solution {
    fun generateParenthesis(n: Int): List<String> {
        if(n == 0) {
            return listOf()
        }
        return generate(n, "", 0, 0, mutableSetOf()).toList()
    }

    private fun generate(n: Int, currString: String, nLeft: Int, nRight: Int, set: MutableSet<String>): MutableSet<String> {
        if(currString.length == 2*n) {
            set.add(currString)
            return set
        }
        if(nLeft < n) {
            set.addAll(generate(n, "$currString(", nLeft+1, nRight, set))
        }
        if(nRight < nLeft) {
            set.addAll(generate(n, "$currString)", nLeft, nRight+1, set))
        }
        return set
    }
}