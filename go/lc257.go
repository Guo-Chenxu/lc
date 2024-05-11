package main

import "strconv"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func binaryTreePaths(root *TreeNode) []string {
	res := []string{}

	var dfs func(cur *TreeNode, curPath string)
	dfs = func(cur *TreeNode, curPath string) {
		if cur == nil {
			return
		}

		if curPath != "" {
			curPath = curPath + "->" + strconv.Itoa(cur.Val)
		} else {
			curPath = strconv.Itoa(cur.Val)
		}
		if cur.Left == nil && cur.Right == nil {
			res = append(res, curPath)
			return
		}
		dfs(cur.Left, curPath)
		dfs(cur.Right, curPath)
	}

	dfs(root, "")
	return res
}
