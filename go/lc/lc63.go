package main

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	if obstacleGrid[0][0] == 1 {
		return 0
	}

	m, n := len(obstacleGrid), len(obstacleGrid[0])
	dp := make([][]int, m)
	for i := range dp {
		dp[i] = make([]int, n)
	}

	dp[0][0] = 1
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if obstacleGrid[i][j] == 0 {
				if i >= 1 {
					dp[i][j] += dp[i-1][j]
				}
				if j >= 1 {
					dp[i][j] += dp[i][j-1]
				}
			}
		}
	}

	return dp[m-1][n-1]
}
