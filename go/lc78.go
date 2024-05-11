package main

func subsets(nums []int) [][]int {
	ans := make([][]int, 0)

	var dfs func(idx int, path []int)
	dfs = func(idx int, path []int) {
		temp := make([]int, len(path))
		copy(temp, path)
		ans = append(ans, temp)

		for i := idx; i < len(nums); i++ {
			path = append(path, nums[i])
			dfs(i+1, path)
			path = path[:len(path)-1]
		}
	}

	dfs(0, []int{})
	return ans
}