package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeElements(head *ListNode, val int) *ListNode {
	dummy := &ListNode{Next: head}
	pre, now := dummy, dummy.Next
	for now != nil {
		if now.Val == val {
			pre.Next = now.Next
		} else {
			pre = pre.Next
		}
		now = now.Next
	}
	return dummy.Next
}
