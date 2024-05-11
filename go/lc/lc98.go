package main

import "math"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isValidBST(root *TreeNode) bool {
	var check func(node *TreeNode, min, max int) bool
	check = func(node *TreeNode, min, max int) bool {
		if node == nil {
			return true
		}
		if node.Val <= min || node.Val >= max {
			return false
		}
		return check(node.Left, min, node.Val) &&
			check(node.Right, node.Val, max)
	}

	return check(root, math.MinInt, math.MaxInt)
}

// func isValidBST(root *TreeNode) bool {
// 	vals := make([]int, 0)
// 	var inorder func(node *TreeNode)
// 	inorder = func(node *TreeNode) {
// 		if node == nil {
// 			return
// 		}
// 		inorder(node.Left)
// 		vals = append(vals, node.Val)
// 		inorder(node.Right)
// 	}

// 	inorder(root)
// 	for i := 1; i < len(vals); i++ {
// 		if vals[i] <= vals[i-1] {
// 			return false
// 		}
// 	}
// 	return true
// }
