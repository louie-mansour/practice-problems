import leetcode.swapnodesinpairs.ListNode
import leetcode.swapnodesinpairs.Solution

fun main(args: Array<String>) {
    val solution = Solution()
    val ln1 = ListNode(1)
    val ln2 = ListNode(2)
    val ln3 = ListNode(3)
    val ln4 = ListNode(4)
    val ln5 = ListNode(5)
    val ln6 = ListNode(6)
    ln1.next = ln2
    ln2.next = ln3
    ln3.next = ln4
    ln4.next = ln5
    ln5.next = ln6
    val head = solution.swapPairs(ln1)
    return
}