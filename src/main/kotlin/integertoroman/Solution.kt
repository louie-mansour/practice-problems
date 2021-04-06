package integertoroman

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given an integer, convert it to a roman numeral.
 */

class Solution {
    fun intToRoman(num: Int): String {
        var diviser = 1000
        val sb = StringBuilder()
        var value = num
        while(diviser > 0) {
            addNumerals(sb, diviser, value / diviser)
            value %= diviser
            diviser /= 10
        }
        return sb.toString()
    }

    private fun addNumerals(sb: StringBuilder, diviser: Int, value: Int) {
        if(value == 0) { return }
        if(diviser == 1000) { sb.append("M".repeat(value)); return }
        if(diviser == 100) {
            if(value <= 3) { sb.append("C".repeat(value)); return }
            if(value == 4) { sb.append("CD"); return }
            if(value < 9) { sb.append("D"); sb.append("C".repeat(value - 5)); return }
            sb.append("CM"); return
        }
        if(diviser == 10) {
            if(value <= 3) { sb.append("X".repeat(value)); return }
            if(value == 4) { sb.append("XL"); return }
            if(value <= 8) { sb.append("L"); sb.append("X".repeat(value - 5)); return }
            sb.append("XC"); return
        }
        if(diviser == 1) {
            if(value <= 3) { sb.append("I".repeat(value)); return }
            if(value == 4) { sb.append("IV"); return }
            if(value <= 8) { sb.append("V"); sb.append("I".repeat(value - 5)); return }
            sb.append("IX"); return
        }
        return
    }
}