package main

func findSubsequences(nums []int) [][]int {
	ans := make([][]int, 0)

	var dfs func(idx int, path []int)
	dfs = func(idx int, path []int) {
		if len(path) >= 2 {
			temp := make([]int, len(path))
			copy(temp, path)
			ans = append(ans, temp)
		}

		// 本层不能使用相同数字
		vis := make([]bool, 201)
		for i := idx; i < len(nums); i++ {
			if !(len(path) == 0 || nums[i] >= path[len(path)-1]) {
				continue
			}
			if vis[nums[i]+100] {
				continue
			}
			vis[nums[i]+100] = true
			path = append(path, nums[i])
			dfs(i+1, path)
			path = path[:len(path)-1]
		}
	}

	dfs(0, []int{})
	return ans
}
