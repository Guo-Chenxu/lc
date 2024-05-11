package main

func maxProfit(prices []int, fee int) int {
	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	dp := make([][3]int, len(prices))
	dp[0][1] = -prices[0]
	for i := 1; i < len(prices); i++ {
		dp[i][1] = max(dp[i-1][2]-prices[i], dp[i-1][1])
		dp[i][2] = max(dp[i-1][1]+prices[i]-fee, dp[i-1][2])
	}

	return dp[len(prices)-1][2]
}
