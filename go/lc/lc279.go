package main

func numSquares(n int) int {
	dp := make([]int, n+1)
	for i := 1; i <= n; i++ {
		dp[i] = n
	}

	for i := 0; i <= n; i++ {
		for j := i * i; j <= n; j++ {
			if dp[j-i*i]+1 < dp[j] {
				dp[j] = dp[j-i*i] + 1
			}
		}
	}

	return dp[n]
}
