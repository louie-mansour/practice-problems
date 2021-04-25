import leetcode.mergeintervals.Solution

fun main(args: Array<String>) {
    val solution = Solution()
    val res = solution.merge(listOf(
        listOf(1, 4),
        listOf(4, 5)
    ).map { it.toIntArray() }.toTypedArray())
    return
}