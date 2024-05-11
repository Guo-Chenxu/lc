package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteDuplicates(head *ListNode) *ListNode {
	pre := &ListNode{Next: head}
	dummy := pre

	for cur := dummy.Next; cur != nil && cur.Next != nil; {
		for cur.Next != nil && cur.Next.Val != cur.Val {
			cur, pre = cur.Next, pre.Next
		}
		if cur.Next != nil && cur.Val == cur.Next.Val {
			for cur.Next != nil && cur.Next.Val == cur.Val {
				cur.Next = cur.Next.Next
			}
			pre.Next = cur.Next
			cur = pre.Next
		}
	}

	return dummy.Next
}
