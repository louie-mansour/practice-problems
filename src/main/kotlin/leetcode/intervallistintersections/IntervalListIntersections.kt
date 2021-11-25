package leetcode.intervallistintersections

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class IntervalListIntersections {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        val intersections = HashSet<IntArray>()
        // iterate on each element in the firstList
        for(firstElements in firstList) {
            // filter for intersections on the second list (no redundant intersections with only 2 lists)
            secondList
                .filter { isIntersecting(firstElements, it) }
                .map { closedInterval(firstElements, it) }
                .forEach { intersections.add(it) }
        }
        return intersections.toList().sortedBy { it[0] }.toTypedArray()
    }

    private fun isIntersecting(a: IntArray, b: IntArray): Boolean {
        return (b[0] >= a[0] && b[0] <= a[1])
                || (b[1] >= a[0] && b[1] <= a[1])
                || (a[0] >= b[0] && a[0] <= b[0])
                || (a[1] >= b[0] && a[1] <= b[1])
    }

    private fun closedInterval(a: IntArray, b: IntArray): IntArray {
        return listOf(a[0].coerceAtLeast(b[0]), a[1].coerceAtMost(b[1])).toIntArray()
    }

    @Test
    fun test() {
        Assertions.assertEquals(
            listOf(listOf(1, 2), listOf(5, 5), listOf(8, 10), listOf(15, 23), listOf(24, 24), listOf(25, 25)).map { it.toIntArray() }.toTypedArray(),
            intervalIntersection(
                listOf(listOf(0, 2), listOf(5, 10), listOf(13, 23), listOf(24, 25)).map { it.toIntArray() }.toTypedArray(),
                listOf(listOf(1, 5), listOf(8, 12), listOf(15, 24), listOf(25, 26)).map { it.toIntArray() }.toTypedArray()
            )
        )
    }
}