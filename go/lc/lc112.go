package main

func hasPathSum(root *TreeNode, targetSum int) bool {
	sum := make(map[int]int, 0)

	var calPathSum func(cur *TreeNode, curSum int)
	calPathSum = func(cur *TreeNode, curSum int) {
		if cur == nil {
			return
		}
		curSum += cur.Val
		if cur.Left == nil && cur.Right == nil {
			sum[curSum] = 1
			return
		}
		calPathSum(cur.Left, curSum)
		calPathSum(cur.Right, curSum)
	}

	calPathSum(root, 0)
	_, ok := sum[targetSum]
	return ok
}
