package zigzagconversion
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
 */

class Solution {
    fun convert(s: String, numRows: Int): String {
        if(numRows == 1) return s

        val sb = StringBuilder()
        var position: Int
        var iter: Int

        for(r in 0 until numRows) {
            position = r
            iter = 0
            while(position < s.length) {
                sb.append(s[position])
                if(r == 0) {
                    position += 2 * (numRows - 1)
                } else if(r == (numRows - 1)) {
                    position += 2 * r
                } else if(iter % 2 == 0){
                    position += 2 * (numRows - r - 1)
                } else {
                    position += 2 * r
                }
                iter += 1
            }
        }
        return sb.toString()
    }
}