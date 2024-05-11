package main

func numDistinct(s string, t string) int {
	m, n := len(s), len(t)
	dp := make([][]int, m+1)
	for i := 0; i <= m; i++ {
		dp[i] = make([]int, n+1)
		dp[i][0] = 1
	}

	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			// 可以使用当前字符匹配, 也可以选择不适用
			// 比如 bagg bag 中的第二个g,
			// 选择使用它匹配就是 dp[i - 1][j - 1] t 前一个字符和 s 前一个字符最大匹配个数
			// 不使用就是 dp[i - 1][j] t 当前字符和 s 前一个字符最大匹配个数
			if s[i-1] == t[j-1] {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
			} else {
				dp[i][j] = dp[i-1][j]
			}
		}
	}

	return dp[m][n]
}
