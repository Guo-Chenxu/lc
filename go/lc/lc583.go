package main

// // 转换成求最长子序列的长度, 然后再减去最长子序列

// func minDistance(word1 string, word2 string) int {
// 	m, n := len(word1), len(word2)
// 	dp := make([][]int, m+1)
// 	for i := 0; i <= m; i++ {
// 		dp[i] = make([]int, n+1)
// 	}

// 	length := 0
// 	for i := 1; i <= m; i++ {
// 		for j := 1; j <= n; j++ {
// 			if word1[i-1] == word2[j-1] {
// 				dp[i][j] = dp[i-1][j-1] + 1
// 			} else {
// 				dp[i][j] = func(a, b int) int {
// 					if a > b {
// 						return a
// 					}
// 					return b
// 				}(dp[i-1][j], dp[i][j-1])
// 			}
// 			if dp[i][j] > length {
// 				length = dp[i][j]
// 			}
// 		}
// 	}

// 	return m + n - length - length
// }

// 直接dp删除字符的做法

func minDistance(word1 string, word2 string) int {
	m, n := len(word1), len(word2)
	dp := make([][]int, m+1)
	for i := range dp {
		dp[i] = make([]int, n+1)
		dp[i][0] = i
	}
	for j := 0; j <= n; j++ {
		dp[0][j] = j
	}

	min := func(a, b int) int {
		if a < b {
			return a
		}
		return b
	}

	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1]
			} else {
				dp[i][j] = min(dp[i-1][j-1]+2, min(dp[i-1][j]+1, dp[i][j-1]+1))
			}
		}
	}

	return dp[m][n]
}
