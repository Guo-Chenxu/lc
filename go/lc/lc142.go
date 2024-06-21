package main

func detectCycle(head *ListNode) *ListNode {
	fi, se := head, head
	for fi != nil && fi.Next != nil {
		fi = fi.Next.Next
		se = se.Next
		if fi == se {
			for head != se {
				head = head.Next
				se = se.Next
			}
			return head
		}
	}
	return nil
}
