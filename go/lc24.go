package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func swapPairs(head *ListNode) *ListNode {
	dummyHead := &ListNode{Next: head}
	cur := dummyHead
	for cur.Next != nil && cur.Next.Next != nil{
		fi := cur.Next
		se := cur.Next.Next
		
		cur.Next = se
		fi.Next = se.Next
		se.Next = fi

		cur = fi
	}
	return dummyHead.Next
}
