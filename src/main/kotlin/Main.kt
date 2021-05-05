import leetcode.courseschedule3.Solution

fun main(args: Array<String>) {
    val solution = Solution()
    solution.scheduleCourse(listOf(
        listOf(7, 16),
        listOf(2, 3),
        listOf(3, 12),
        listOf(3, 14),
        listOf(10, 19),
        listOf(10, 16),
        listOf(6, 8),
        listOf(6, 11),
        listOf(3, 13),
        listOf(6, 16)
    ).map { it.toIntArray() }.toTypedArray())
    return
}