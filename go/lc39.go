package main

func combinationSum(candidates []int, target int) [][]int {
	ans := make([][]int, 0)
	var dfs func(idx, sum int, path []int)
	dfs = func(idx, sum int, path []int) {
		if sum == target {
			temp := make([]int, len(path))
			copy(temp, path)
			ans = append(ans, temp)
			return
		}
		for i := idx; i < len(candidates); i++ {
			if sum+candidates[i] <= target {
				path = append(path, candidates[i])
				dfs(i, sum+candidates[i], path)
				path = path[:len(path)-1]
			} 
		}
	}

	dfs(0, 0, []int{})
	return ans
}
