package com.example.dynamicprogrammingpractice


fun main() {
    testReverseList()
}

fun testReverseList() {
    val generateLinkedList = generateLinkedList(10)
    var next: ListNode? = generateLinkedList
    while (next != null) {
        println(next.`val`)
        next = next.next
    }
    val reverseList = reverseList(generateLinkedList(10))
    var nextReversed = reverseList
    while (nextReversed != null) {
        println(nextReversed.`val`)
        nextReversed = nextReversed.next
    }
}

fun generateLinkedList(number: Int): ListNode {
    var l1 = ListNode(1)
    val temp = l1
    for (n in 2..number) {
        val next = ListNode(n)
        l1.next = next
        l1 = next
    }

    return temp
}


/**
 * Reverse the linked list by changing the next pointer of each node.
 *
 * @param head the head of the linked list
 * @return The reversed list.
 */
fun reverseList(head: ListNode?): ListNode? {
    if (head == null) return head

    var previous: ListNode? = null
    var current = head
    var next: ListNode?
    while (current != null) {
        next = current.next
        current.next = previous
        previous = current
        current = next
    }
    return previous
}
