package hackerrank.nondivisiblesubset

import org.junit.jupiter.api.Test
import java.util.*

class NonDivisibleSubset {
    fun nonDivisibleSubset(k: Int, s: Array<Int>): Int {
        // Write your code here
        val q: Queue<Set<Int>> = LinkedList()
        q.add(s.toSet())
        return nonDivisibleSubset(k, q, mutableSetOf())
    }

    private fun nonDivisibleSubset(k: Int, q: Queue<Set<Int>>, memo: MutableSet<Set<Int>>): Int {
        while(q.isNotEmpty()) {
            val s = q.poll()
            if(!hasPairMultipleOfK(k, s)) return s.size
            for(el in s) {
                val newSet = s - el
                if(!memo.contains(newSet)) {
                    q.add(newSet)
                    memo.add(newSet)
                }
            }
        }

        return 0
    }

    private fun hasPairMultipleOfK(k: Int, s: Set<Int>): Boolean {
        val l = s.toList()
        for(i in l.indices) {
            for(j in i + 1 until l.size) {
                if((l[i] + l[j]) % k == 0) {
                    return true
                }
            }
        }
        return false
    }

    @Test
    fun test() {
        println(nonDivisibleSubset(3, intArrayOf(1, 7, 2, 4).toTypedArray()))
    }
}