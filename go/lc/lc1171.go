package main

func removeZeroSumSublists(head *ListNode) *ListNode {
	res := &ListNode{}
	res.Next = head
	seen := map[int]*ListNode{}
	prefix := 0
	for node := res; node != nil; node = node.Next {
		prefix += node.Val
		seen[prefix] = node
	}
	prefix = 0
	for node := res; node != nil; node = node.Next {
		prefix += node.Val
		node.Next = seen[prefix].Next
	}
	return res.Next
}
