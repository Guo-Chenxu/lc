package main

func rob(root *TreeNode) int {
	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	var dfs func(cur *TreeNode) [2]int
	dfs = func(cur *TreeNode) [2]int {
		if cur == nil {
			return [2]int{0, 0}
		}

		l, r := dfs(cur.Left), dfs(cur.Right)

		robCur := cur.Val + l[0] + r[0]
		notRobCur := max(l[0], l[1]) + max(r[0], r[1])
		return [2]int{notRobCur, robCur}
	}

	r := dfs(root)
	return max(r[0], r[1])
}
