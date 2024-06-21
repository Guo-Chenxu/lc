package main

func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	min := func(a, b int) int {
		if a < b {
			return a
		}
		return b
	}

	var dfs func(cur *TreeNode, depth int) int
	dfs = func(cur *TreeNode, depth int) int {
		if cur.Left == nil && cur.Right == nil {
			return depth + 1
		}
		a, b := 0x7fffffff, 0x7fffffff
		if cur.Left != nil {
			a = dfs(cur.Left, depth+1)
		}
		if cur.Right != nil {
			b = dfs(cur.Right, depth+1)
		}
		return min(a, b)
	}
	return dfs(root, 0)
}
