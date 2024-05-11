package main

import "sort"

func subsetsWithDup(nums []int) [][]int {
	ans, vis := make([][]int, 0), make([]bool, len(nums))

	var dfs func(idx int, path []int)
	dfs = func(idx int, path []int) {
		temp := make([]int, len(path))
		copy(temp, path)
		ans = append(ans, temp)

		for i := idx; i < len(nums); i++ {
			if i > 0 && nums[i] == nums[i-1] && vis[i-1] == false {
				continue
			}
			vis[i] = true
			path = append(path, nums[i])
			dfs(i+1, path)
			vis[i] = false
			path = path[:len(path)-1]
		}
	}

	sort.Ints(nums)
	dfs(0, []int{})
	return ans
}
