package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func kthSmallest(root *TreeNode, k int) int {
	ans, cnt := -1, 0
	var dfs func(cur *TreeNode)
	dfs = func(cur *TreeNode) {
		if cur == nil || cnt >= k {
			return
		}
		dfs(cur.Left)
		cnt++
		if cnt == k {
			ans = cur.Val
			return
		}
		dfs(cur.Right)
	}
	dfs(root)
	return ans
}
