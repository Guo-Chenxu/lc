package main

import "sort"

func permuteUnique(nums []int) [][]int {
	ans, vis := make([][]int, 0), make([]bool, len(nums))

	var dfs func(path []int)
	dfs = func(path []int) {
		if len(path) == len(nums) {
			temp := make([]int, len(path))
			copy(temp, path)
			ans = append(ans, temp)
		}

		for i := 0; i < len(nums); i++ {
			if vis[i] || (i > 0 && nums[i] == nums[i-1] && vis[i-1]) {
				continue
			}
			vis[i] = true
			path = append(path, nums[i])
			dfs(path)
			vis[i] = false
			path = path[:len(path)-1]
		}
	}

	sort.Ints(nums)
	dfs([]int{})
	return ans
}
