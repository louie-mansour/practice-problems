import leetcode.rotateimage.Solution

fun main(args: Array<String>) {
    val solution = Solution()
    val matrix = listOf(
        listOf(5, 1, 9, 11).toIntArray(),
        listOf(2, 4, 8, 10).toIntArray(),
        listOf(13, 3, 6, 7).toIntArray(),
        listOf(15, 14, 12, 16).toIntArray()).toTypedArray()
    val res = solution.rotate(matrix)
    return
}