package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func insertIntoBST(root *TreeNode, val int) *TreeNode {
	node := root
	if root == nil {
		return &TreeNode{Val: val, Left: nil, Right: nil}
	}

	for node.Left != nil || node.Right != nil {
		if node.Val > val {
			if node.Left == nil {
				break
			}
			node = node.Left
		} else {
			if node.Right == nil{
				break
			}
			node = node.Right
		}
	}
	if node.Val > val {
		node.Left = &TreeNode{Val: val, Left: nil, Right: nil}
	} else {
		node.Right = &TreeNode{Val: val, Left: nil, Right: nil}
	}

	return root
}
