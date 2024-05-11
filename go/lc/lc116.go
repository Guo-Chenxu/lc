package main

type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

func connect(root *Node) *Node {
	cur := make([]*Node, 0)
	if root == nil {
		return root
	}
	cur = append(cur, root)
	for len(cur) > 0 {
		next := make([]*Node, 0)
		head := cur[0]
		for _, now := range cur {
			if head != now {
				head.Next = now
				head = head.Next
			}
			if now.Left != nil {
				next = append(next, now.Left)
			}
			if now.Right != nil {
				next = append(next, now.Right)
			}
		}
		cur = next
	}
	return root
}
