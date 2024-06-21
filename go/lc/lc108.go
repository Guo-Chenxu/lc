package main

func sortedArrayToBST(nums []int) *TreeNode {
	var dfs func(nums []int, l, r int) *TreeNode
	dfs = func(nums []int, l, r int) *TreeNode {
		if l > r {
			return nil
		}
		mid := ((l + r) >> 1)
		cur := &TreeNode{Val: nums[mid]}
		cur.Left = dfs(nums, l, mid-1)
		cur.Right = dfs(nums, mid+1, r)
		return cur
	}

	return dfs(nums, 0, len(nums)-1)
}
