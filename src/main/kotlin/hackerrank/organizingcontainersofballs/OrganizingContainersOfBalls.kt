package hackerrank.organizingcontainersofballs

import org.junit.jupiter.api.Test

class OrganizingContainersOfBalls {
    fun organizingContainers(container: Array<Array<Int>>): String {
        val containerCapacities = container.map { it.sum() }.associateBy { it }.toMutableMap()
        val ballQuantities = IntArray(container.size)
        StringBuilder()
        container.forEach { c ->
            c.forEachIndexed { i, q -> ballQuantities[i] = ballQuantities[i] + q }
        }

        for(ballQty in ballQuantities) {
            if(!containerCapacities.contains(ballQty)) return "Impossible"
            containerCapacities[ballQty] = containerCapacities[ballQty]?.minus(1)?:0
            if((containerCapacities[ballQty] ?: 0) <= 0) containerCapacities.remove(ballQty)
        }
        return "Possible"
    }

    @Test
    fun test() {
        organizingContainers(listOf(listOf(1, 1), listOf(1, 1)).map { it.toTypedArray() }.toTypedArray())
    }
}