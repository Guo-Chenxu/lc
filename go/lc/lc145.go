package main

func postorder(root *TreeNode, res *[]int) {
	if root == nil {
		return
	}
	postorder(root.Left, res)
	postorder(root.Right, res)
	*res = append(*res, root.Val)
}

func postorderTraversal(root *TreeNode) []int {
	res := make([]int, 0)
	postorder(root, &res)
	return res
}
