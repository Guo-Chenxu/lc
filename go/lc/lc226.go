package main

func invertTree(root *TreeNode) *TreeNode {
	if root == nil {
		return root
	}
	queue := make([]*TreeNode, 0)
	queue = append(queue, root)
	for len(queue) > 0 {
		now := queue[0]
		queue = queue[1:]
		t := now.Left
		now.Left = now.Right
		now.Right = t
		if now.Left != nil {
			queue = append(queue, now.Left)
		}
		if now.Right != nil {
			queue = append(queue, now.Right)
		}
	}
	return root
}
