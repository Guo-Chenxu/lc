package main

func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	var dfs func(cur *TreeNode, depth int) int
	dfs = func(cur *TreeNode, depth int) int {
		if cur == nil || cur.Left == nil && cur.Right == nil {
			return depth + 1
		}
		return max(dfs(cur.Left, depth+1), dfs(cur.Right, depth+1))
	}

	return dfs(root, 0)
}
