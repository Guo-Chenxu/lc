package main

func numEnclaves(grid [][]int) int {
	var dfs func(x, y int)
	dfs = func(x, y int) {
		if x < 0 || x >= len(grid) || y < 0 || y >= len(grid[0]) {
			return
		}

		if grid[x][y] == 1 {
			grid[x][y] = 0
			dfs(x-1, y)
			dfs(x+1, y)
			dfs(x, y-1)
			dfs(x, y+1)
		}
	}

	m, n := len(grid), len(grid[0])
	for i := 0; i < m; i++ {
		if grid[i][0] == 1 {
			dfs(i, 0)
		}
		if grid[i][n-1] == 1 {
			dfs(i, n-1)
		}
	}
	for i := 0; i < n; i++ {
		if grid[0][i] == 1 {
			dfs(0, i)
		}
		if grid[m-1][i] == 1 {
			dfs(m-1, i)
		}
	}

	ans := 0
	for _, g := range grid {
		for _, v := range g {
			if v == 1 {
				ans++
			}
		}
	}

	return ans
}
