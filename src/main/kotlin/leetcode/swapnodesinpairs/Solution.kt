package leetcode.swapnodesinpairs

/*
Given a linked list, swap every two adjacent nodes and return its head.
 */
class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        var head = head
        if(head?.next == null) {
            return head
        }
        var lnPointer0 = head
        var lnPointer1 = head.next
        var nextPointer = lnPointer1?.next

        head = lnPointer1
        lnPointer1?.next = lnPointer0
        lnPointer0.next = nextPointer

        var prevPointer = lnPointer0
        lnPointer0 = nextPointer
        lnPointer1 = lnPointer0?.next
        nextPointer = lnPointer1?.next

        while(lnPointer0 != null && lnPointer1 != null) {
            prevPointer?.next = lnPointer1
            lnPointer1.next = lnPointer0
            lnPointer0.next = nextPointer

            prevPointer = lnPointer0
            lnPointer0 = nextPointer
            lnPointer1 = lnPointer0?.next
            nextPointer = lnPointer1?.next
        }
        return head
    }
}