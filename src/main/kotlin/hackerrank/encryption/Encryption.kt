package hackerrank.encryption

import org.junit.jupiter.api.Test

class Encryption {
    fun encryption(s: String): String {
        val  stringWithoutSpaces= s.filter { !it.isWhitespace() }
        val lengthWithoutSpaces = stringWithoutSpaces.length

        val rowsAndCols = getNumberOfRowsAndColumns(lengthWithoutSpaces)
        return formEncryptedString(stringWithoutSpaces, rowsAndCols.first, rowsAndCols.second)
    }

    private fun getNumberOfRowsAndColumns(l: Int): Pair<Int,Int> {
        val floor = Math.floor(Math.sqrt(l.toDouble())).toInt()
        val ceil = Math.ceil(Math.sqrt(l.toDouble())).toInt()
        var rows = Int.MAX_VALUE
        var cols = Int.MAX_VALUE
        var minValidArea = Int.MAX_VALUE
        for(i in floor..ceil) {
            for(j in i..ceil) {
                if(i * j >= l && i * j < minValidArea) {
                    minValidArea =  i * j
                    rows = i
                    cols = j
                }
            }
        }
        return Pair(rows, cols)
    }

    private fun formEncryptedString(sNoSpaces: String, rows: Int, cols: Int): String {
        val sb = StringBuilder()
        for(r in 0..rows ) {
            for(c in 0..cols) {
                if(sb.filter { !it.isWhitespace() }.length >= sNoSpaces.length) {
                    return sb.toString()
                }
                val stringPositionToPrint = c*cols + r
                if(stringPositionToPrint >= sNoSpaces.length) continue
                if(c == 0 && r != 0) sb.append(" ")
                sb.append(sNoSpaces[stringPositionToPrint])

            }
            listOf(1, 2, 3).groupBy { it }
        }

        return sb.toString()
    }

    private fun getWays(n: Int, coins: Array<Long>, curr: List<Int>, memo: MutableSet<List<Int>>) {
        if(curr.sum() == n) memo.add(curr.sorted())
        if(curr.sum() >= n) return

        for(coin in coins) {
            getWays(n, coins, curr, memo)
        }
    }

    @Test
    fun test() {
        encryption("haveaniceday")
    }
}