package main

func getHeight(cur *TreeNode) int {
	if cur == nil {
		return 0
	}
	l, r := getHeight(cur.Left), getHeight(cur.Right)
	if l == -1 || r == -1 {
		return -1
	}
	if l-r <= 1 && l-r >= -1 {
		if l > r {
			return l + 1
		}
		return r + 1
	}
	return -1
}

func isBalanced(root *TreeNode) bool {
	return getHeight(root) != -1
}
