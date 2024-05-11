package main

func findMaxForm(strs []string, m int, n int) int {
	cnt01 := make([][]int, 0)
	for _, s := range strs {
		t := make([]int, 2)
		for _, c := range s {
			if c == '0' {
				t[0]++
			} else {
				t[1]++
			}
		}
		cnt01 = append(cnt01, t)
	}

	// dp[i][j], 有 i 个 0, j 个 1 的取法
	dp := make([][]int, m+1)
	for i := range dp {
		dp[i] = make([]int, n+1)
	}

	for _, c := range cnt01 {
		for i := m; i >= c[0]; i-- {
			for j := n; j >= c[1]; j-- {
				if dp[i-c[0]][j-c[1]]+1 > dp[i][j] {
					// ! 如果是求最大xxx, 则是比大小然后取最大值
					dp[i][j] = dp[i-c[0]][j-c[1]] + 1
				}
			}
		}
	}

	return dp[m][n]
}
