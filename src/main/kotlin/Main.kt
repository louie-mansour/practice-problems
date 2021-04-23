import leetcode.minimumpathsum.Solution

fun main(args: Array<String>) {
    val solution = Solution()
    val res = solution.minPathSum(
        listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6)
        )
            .map { it.toIntArray() }
            .toTypedArray()
    )
    return
}