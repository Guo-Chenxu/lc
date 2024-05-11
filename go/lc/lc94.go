package main

func inorder(root *TreeNode, res *[]int) {
	if root == nil {
		return
	}
	inorder(root.Left, res)
	*res = append(*res, root.Val)
	inorder(root.Right, res)
}

func inorderTraversal(root *TreeNode) []int {
	res := make([]int, 0)
	inorder(root, &res)
	return res
}