package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func lcaDeepestLeaves(root *TreeNode) *TreeNode {
	maxDepth, ans := 0, &TreeNode{}
	var dfs func(cur *TreeNode, depth int) int
	dfs = func(cur *TreeNode, depth int) int {
		if cur == nil {
			if depth+1 > maxDepth {
				maxDepth = depth + 1
			}
			return depth + 1
		}
		
		l := dfs(cur.Left, depth+1)
		r := dfs(cur.Right, depth+1)
		if l == r && r == maxDepth {
			ans = cur
		}
		if l > r {
			return l
		}
		return r
	}

	dfs(root, 0)
	return ans
}
