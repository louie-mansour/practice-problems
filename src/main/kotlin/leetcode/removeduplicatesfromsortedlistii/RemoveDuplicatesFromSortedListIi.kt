package leetcode.removeduplicatesfromsortedlistii

/**
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
Return the linked list sorted as well.
 */
class RemoveDuplicatesFromSortedListIi {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        // Seems like a pointer problem. I intend to use 2 pointers. One ahead and one behind
        // first edge case to consider is a null head, in which case we return null
        // second edge case to consider is a single element list in which case we return the single element
        // third edge case to consider is if the first elements are repeated and should be removed (should also handle case where all elements are repeated and return null)


        // Step 1: handle the easy edge cases upfront
        if(head == null) return null

        // Step 2: correctly set the head of the list
        val noDupsHead = ListNode(Int.MIN_VALUE)
        noDupsHead.next = head

        // Step 3: Set the 2 pointers onto the list
        if(noDupsHead.next == null) return null
        var trailingP = noDupsHead
        var leadingP = noDupsHead.next

        // Step 4: main part of the algo
        while(leadingP != null && leadingP.next != null) {
            if(leadingP.`val` == leadingP.next!!.`val`) {
                val repeatedVal = leadingP.`val`
                while(leadingP != null && leadingP.`val` == repeatedVal) {
                    leadingP = leadingP.next
                }
                trailingP.next = leadingP
            } else {
                trailingP = trailingP.next!!
                leadingP = leadingP.next
            }
        }
        return noDupsHead.next
    }
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}