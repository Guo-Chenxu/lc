package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func levelOrder(root *TreeNode) [][]int {
	res, cur := make([][]int, 0), make([]*TreeNode, 0)
	if root == nil {
		return res
	}
	cur = append(cur, root)
	for len(cur) > 0 {
		next := make([]*TreeNode, 0)
		temp := make([]int, 0)
		for _, now := range cur {
			temp = append(temp, now.Val)
			if now.Left != nil {
				next = append(next, now.Left)
			}
			if now.Right != nil {
				next = append(next, now.Right)
			}
		}
		cur = next
		res = append(res, temp)
	}
	return res
}
