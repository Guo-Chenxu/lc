package main

func maxProfit(k int, prices []int) int {
	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	dp := make([][]int, len(prices))
	for i := 0; i < len(prices); i++ {
		dp[i] = make([]int, k+k+1)
	}

	for i := 1; i <= k+k; i += 2 {
		dp[0][i] = -prices[0]
	}

	for i := 1; i < len(prices); i++ {
		for j := 1; j <= k+k; j += 2 {
			dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]-prices[i])
			dp[i][j+1] = max(dp[i-1][j+1], dp[i-1][j-1+1]+prices[i])
		}
	}

	return dp[len(prices)-1][k+k]
}
