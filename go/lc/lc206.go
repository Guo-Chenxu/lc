package main

func reverseList(head *ListNode) *ListNode {
	var pre *ListNode
	next := head
	for next != nil {
		temp := next.Next
		next.Next = pre
		pre = next
		next = temp
	}
	return pre
}
