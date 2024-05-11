package main

func largestIsland(grid [][]int) int {
	no, mg := 2, make(map[int]int, 0)
	dir := [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}

	var dfs func(x, y int)
	dfs = func(x, y int) {
		if x < 0 || x >= len(grid) || y < 0 || y >= len(grid[0]) || grid[x][y] != 1 {
			return
		}

		grid[x][y] = no
		mg[no]++
		for i := 0; i < 4; i++ {
			dfs(x+dir[i][0], y+dir[i][1])
		}
	}

	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	ans := 0
	for i, g := range grid {
		for j, v := range g {
			if v == 1 {
				dfs(i, j)
				ans = max(ans, mg[no])
				no++
			}
		}
	}

	for i, g := range grid {
		for j, v := range g {
			if v == 0 {
				t := 1
				vis := make([]bool, no+1)
				for k := 0; k < 4; k++ {
					nx, ny := i+dir[k][0], j+dir[k][1]
					if nx >= 0 && nx < len(grid) && ny >= 0 && ny < len(grid[0]) && !vis[grid[nx][ny]] {
						t += mg[grid[nx][ny]]
						vis[grid[nx][ny]] = true
					}
				}
				ans = max(ans, t)
			}
		}
	}

	return ans
}
