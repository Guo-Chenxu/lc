package main

func getMinimumDifference(root *TreeNode) int {
	vals := make([]int, 0)
	var inorder func(node *TreeNode)
	inorder = func(node *TreeNode) {
		if node == nil {
			return
		}
		inorder(node.Left)
		vals = append(vals, node.Val)
		inorder(node.Right)
	}

	inorder(root)
	min := 0x7fffffff
	for i := 1; i < len(vals); i++ {
		if vals[i]-vals[i-1] < min {
			min = vals[i] - vals[i-1]
		}
	}
	return min
}
