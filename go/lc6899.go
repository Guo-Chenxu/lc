package main

func maximumJumps(nums []int, target int) int {
	length := len(nums)
	dp := make([]int, length)

	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	for i := 1; i < length; i++ {
		dp[i] = -1
		for j := 0; j < i; j++ {
			if dp[j] != -1 && -target <= nums[j]-nums[i] && nums[j]-nums[i] <= target {
				dp[i] = max(dp[i], dp[j]+1)
			}
		}
	}

	return dp[length-1]
}
