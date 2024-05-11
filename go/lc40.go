package main

import "sort"

func combinationSum2(candidates []int, target int) [][]int {
	ans := make([][]int, 0)
	sort.Ints(candidates)

	var dfs func(idx, sum int, path []int)
	dfs = func(idx, sum int, path []int) {
		if sum == target {
			temp := make([]int, len(path))
			copy(temp, path)
			ans = append(ans, temp)
			return
		}
		for i := idx; i < len(candidates); i++ {
			if i > 0 && candidates[i] == candidates[i-1] {
				continue
			}
			if sum+candidates[i] <= target {
				path = append(path, candidates[i])
				dfs(i+1, sum+candidates[i], path)
				path = path[:len(path)-1]
			} else {
				return
			}
		}
	}

	dfs(0, 0, []int{})
	return ans
}
