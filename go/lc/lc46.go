package main

func permute(nums []int) [][]int {
	ans, vis := make([][]int, 0), make([]bool, len(nums))

	var dfs func(path []int)
	dfs = func(path []int) {
		if len(path) == len(nums) {
			temp := make([]int, len(path))
			copy(temp, path)
			ans = append(ans, temp)
		}

		for i := 0; i < len(nums); i++ {
			if vis[i] {
				continue
			}
			vis[i] = true
			path = append(path, nums[i])
			dfs(path)
			vis[i] = false
			path = path[:len(path)-1]
		}
	}

	dfs([]int{})
	return ans
}
