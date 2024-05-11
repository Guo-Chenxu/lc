package main

func pacificAtlantic(heights [][]int) [][]int {
	m, n := len(heights), len(heights[0])
	p, a := make([][]bool, m), make([][]bool, m)
	for i := range p {
		p[i] = make([]bool, n)
		a[i] = make([]bool, n)
	}

	dir := [4][2]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}

	var dfs func(x, y int, g *[][]bool)
	dfs = func(x, y int, g *[][]bool) {
		if (*g)[x][y] {
			return
		}

		(*g)[x][y] = true
		for i := 0; i < 4; i++ {
			nx, ny := x+dir[i][0], y+dir[i][1]
			if nx < 0 || nx >= m || ny < 0 || ny >= n || heights[nx][ny] < heights[x][y] {
				continue
			}
			dfs(nx, ny, g)
		}
	}

	for i := 0; i < m; i++ {
		dfs(i, 0, &p)
		dfs(i, n-1, &a)
	}
	for i := 0; i < n; i++ {
		dfs(0, i, &p)
		dfs(m-1, i, &a)
	}

	ans := make([][]int, 0)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if p[i][j] && a[i][j] {
				ans = append(ans, []int{i, j})
			}
		}
	}

	return ans
}
