package codewars

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.math.pow

class RevRot {
    fun revRot(nums:String, sz:Int): String {
        if(sz == 0) return ""

        return nums
            .chunked(sz)
            .filter { it.length == sz }
            .joinToString("") { revRot(it) }
    }

    private fun revRot(str: String): String {
        val isReverse = str.toList().map { c -> (c.toInt() - '0'.toInt()).toDouble().pow(3).toInt() }
            .reduce { a, b -> a + b } % 2 == 0
        return if(isReverse) {
            str.reversed()
        } else {
            str.takeLast(str.length - 1) + str.take(1)
        }
    }

    @Test
    fun test1() {
        println("Fixed Tests: revRot")
        var s = "733049910872815764"
        assertEquals(revRot(s, 5), "330479108928157")
        s = "73304991087281576455176044327690580265896"
        assertEquals(revRot(s, 8), "1994033775182780067155464327690480265895")
        s = "73304991087281576455176044327690580265896896028"
        assertEquals(revRot(s, 8), "1994033775182780067155464327690480265895")

    }
}