package leetcode.backspacestringcompare

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class BackspaceStringCompare {
    /*
    Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
    Note that after backspacing an empty text, the text will continue empty.
     */
    fun backspaceCompare(s: String, t: String): Boolean {
        return evaluate(s) == evaluate(t)
    }

    private fun evaluate(s: String): String {
        val stack = ArrayDeque<Char>()
        for(c in s) {
            if(c != '#') {
                stack.push(c)
            } else if(stack.isNotEmpty()) {
                 stack.pop()
            }
        }
        return stack.joinToString("")
    }

    @Test
    fun test() {
//        Assertions.assertTrue(backspaceCompare("ab#c", "ad#c"))
//        Assertions.assertTrue(backspaceCompare("ab##", "c#d#"))
//        Assertions.assertTrue(backspaceCompare("a##c", "#a#c"))
//        Assertions.assertFalse(backspaceCompare("a#b", "c"))
        Assertions.assertTrue(backspaceCompare("y#fo##f", "y#f#o##f"))
    }
}