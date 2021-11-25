package hackerrank.biggerisgreater

import org.junit.jupiter.api.Test

class BiggerIsGreater {
    fun biggerIsGreater(w: String): String {
        if(w.length <= 1) return "no answer"

        var idxOfSmallest = w.length - 1
        var word = w.toCharArray()

        for(i in (word.size - 2) downTo 0) {
            if(word[i] < word[idxOfSmallest]) {
                val iVal = word[i]
                word[i] = w[idxOfSmallest]
                word[idxOfSmallest] = iVal
                return word.joinToString("")
            }
            idxOfSmallest = i
        }
        return "no answer"
    }

    @Test
    fun test() {
        biggerIsGreater("ab")
    }
}