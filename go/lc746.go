package main

func minCostClimbingStairs(cost []int) int {
	if len(cost) < 2 {
		return 0
	}

	min := func(a, b int) int {
		if a < b {
			return a
		}
		return b
	}

	dp := make([]int, len(cost)+1)
	dp[0], dp[1] = 0, 0
	for i := 2; i <= len(cost); i++ {
		dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])
	}
	return dp[len(cost)]
}
