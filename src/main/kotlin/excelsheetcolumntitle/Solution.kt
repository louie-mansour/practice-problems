package excelsheetcolumntitle

/*
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...
 */
class Solution {
    fun convertToTitle(columnNumber: Int): String {
        var columnLetters = ""
        var divisor = columnNumber

        while(divisor > 0) {
            columnLetters = ((divisor - 1) % CONST + 65).toChar() + columnLetters
            divisor = (divisor - 1) / CONST
        }
        return columnLetters
    }

    companion object {
        const val CONST = 26
    }
}