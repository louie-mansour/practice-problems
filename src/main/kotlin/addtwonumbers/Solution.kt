package addtwonumbers

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class Solution {
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
        var i1: ListNode? = l1
        var i2: ListNode? = l2

        var currentValue = (i1!!.`val` + i2!!.`val`) % 10
        var carryOver = (i1.`val` + i2.`val`) / 10
        var currentListNode = ListNode(currentValue)
        val firstListNode = currentListNode
        var prevListNode = currentListNode
        i1 = i1.next
        i2 = i2.next

        var sum: Int
        while(i1 != null || i2!= null || carryOver != 0) {
            sum = ((i1?.`val`?:0) + (i2?.`val`?:0) + carryOver)
            currentValue = sum % 10
            carryOver = sum / 10
            currentListNode = ListNode(currentValue)
            prevListNode.next = currentListNode
            prevListNode = currentListNode
            i1 = i1?.next
            i2 = i2?.next
        }
        return firstListNode
    }
}