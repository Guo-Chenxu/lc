package main

var dp [100][100]int

// 前闭后开
func dfs(nums []int, sum, i, j, m int) bool {
	if i+1 == j || i+2 == j {
		return true
	}

	if dp[i][j] != 0 {
		return dp[i][j] == 1
	}

	a := (sum-nums[i] >= m)
	b := (sum-nums[j-1] >= m)

	if a && b {
		dp[i+1][j], dp[i][j-1] = 1, 1
		return dfs(nums, sum-nums[i], i+1, j, m) || dfs(nums, sum-nums[j-1], i, j-1, m)
	} else if a {
		dp[i+1][j], dp[i][j-1] = 1, 0
		return dfs(nums, sum-nums[i], i+1, j, m)
	} else if b {
		dp[i+1][j], dp[i][j-1] = 2, 1
		return dfs(nums, sum-nums[j-1], i, j-1, m)
	} else {
		dp[i+1][j], dp[i][j-1] = 2, 2
		return false
	}
}

func canSplitArray(nums []int, m int) bool {
	for i := range nums {
		if i > 1 && nums[i]+nums[i-1] >= m {
			return true
		}
	}
	return false
}
