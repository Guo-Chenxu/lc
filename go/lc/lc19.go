package main

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	dummy := &ListNode{Next: head}
	fi, se := dummy, dummy
	for i := 0; i < n; i++ {
		fi = fi.Next
	}
	for fi.Next != nil {
		fi = fi.Next
		se = se.Next
	}
	se.Next = se.Next.Next
	return dummy.Next
}
