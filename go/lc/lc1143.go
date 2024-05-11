package main

func longestCommonSubsequence(text1 string, text2 string) int {
	m, n := len(text1), len(text2)
	// 这样定义可以让下标从 1 开始, 避免溢出判断
	dp := make([][]int, m+1)
	for i := 0; i <= m; i++ {
		dp[i] = make([]int, n+1)
	}

	ans := 0
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if text1[i-1] == text2[j-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = func(a, b int) int {
					if a > b {
						return a
					}
					return b
				}(dp[i-1][j], dp[i][j-1])
			}
			if dp[i][j] > ans {
				ans = dp[i][j]
			}
		}
	}

	return ans
}
