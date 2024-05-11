package main

func longestPalindromeSubseq(s string) int {
	n := len(s)
	dp := make([][]int, n)
	for i := range dp {
		dp[i] = make([]int, n)
	}

	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	ans := 1
	for i := n - 1; i >= 0; i-- {
		for j := i; j < n; j++ {
			if s[i] == s[j] {
				if j-i <= 1 {
					dp[i][j] = j - i + 1
				} else {
					dp[i][j] = dp[i+1][j-1] + 2
				}
			} else {
				dp[i][j] = max(dp[i+1][j], dp[i][j-1])
			}
			ans = max(ans, dp[i][j])
		}
	}

	return ans
}
