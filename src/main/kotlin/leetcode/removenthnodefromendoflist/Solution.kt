package leetcode.removenthnodefromendoflist

/**
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Follow up: Could you do this in one pass?
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var p1 = head
        var p2 = head

        for(i in 0 until n) {
            if(p1 == null) {
                return head
            }
            p1 = p1.next
        }
        if(p1 == null) {
            return head?.next
        }
        while(p1?.next != null) {
            p1 = p1.next
            p2 = p2?.next
        }
        p2?.next = p2?.next?.next
        return head
    }
}