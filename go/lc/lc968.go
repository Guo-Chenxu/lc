package main

/**
 * 0 没有覆盖
 * 1 有摄像头
 * 2 被覆盖
 */
// func minCameraCover(root *TreeNode) int {
// 	ans := 0

// 	var dfs func(cur *TreeNode) int
// 	dfs = func(cur *TreeNode) int {
// 		if cur == nil {
// 			return 2
// 		}

// 		l, r := dfs(cur.Left), dfs(cur.Right)

// 		if l == 0 || r == 0 {
// 			ans++
// 			return 1
// 		}
// 		if l == 1 || r == 1 {
// 			return 2
// 		}
// 		if l == 2 && r == 2 {
// 			return 0
// 		}

// 		return -1
// 	}

// 	if dfs(root) == 0 {
// 		ans++
// 	}
// 	return ans
// }

// 简化版
func minCameraCover(root *TreeNode) int {
	ans := 0

	var dfs func(cur *TreeNode) int
	dfs = func(cur *TreeNode) int {
		if cur == nil {
			return 2
		}

		l, r := dfs(cur.Left), dfs(cur.Right)
		if l == 0 || r == 0 {
			ans++
			return 1
		} else if l == 2 && r == 2 {
			return 0
		} else {
			return 2
		}
	}

	if dfs(root) == 0 {
		ans++
	}
	return ans
}
