package main

func findMode(root *TreeNode) []int {
	vals := make(map[int]int, 0)
	res, maxCount := make([]int, 0), -1

	var inorder func(node *TreeNode)
	inorder = func(node *TreeNode) {
		if node == nil {
			return
		}

		vals[node.Val]++
		if vals[node.Val] > maxCount {
			maxCount = vals[node.Val]
		}

		inorder(node.Left)
		inorder(node.Right)
	}

	inorder(root)
	for k, v := range vals {
		if v == maxCount {
			res = append(res, k)
		}
	}
	return res
}
