package main

func maxAreaOfIsland(grid [][]int) int {
	var dfs func(x, y int) int
	dfs = func(x, y int) int {
		if x < 0 || x >= len(grid) || y < 0 || y >= len(grid[0]) {
			return 0
		}

		res := 0
		if grid[x][y] == 1 {
			grid[x][y] = 0
			res = 1
			res += dfs(x-1, y)
			res += dfs(x+1, y)
			res += dfs(x, y-1)
			res += dfs(x, y+1)
		}
		return res
	}

	ans := 0
	for i, g := range grid {
		for j, v := range g {
			if v == 1 {
				t := dfs(i, j)
				if t > ans {
					ans = t
				}
			}
		}
	}

	return ans
}
