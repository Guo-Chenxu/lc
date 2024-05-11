package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sumOfLeftLeaves(root *TreeNode) int {
	var getSum func(cur *TreeNode, flag int) int
	getSum = func(cur *TreeNode, flag int) int {
		if cur == nil {
			return 0
		}
		if cur.Left == nil && cur.Right == nil {
			if flag == 0 {
				return cur.Val
			} else {
				return 0
			}
		}
		return getSum(cur.Left, 0) + getSum(cur.Right, 1)
	}

	return getSum(root, -1)
}
