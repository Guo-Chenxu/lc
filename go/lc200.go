package main

// // dfs
// func numIslands(grid [][]byte) int {
// 	var dfs func(x, y int)
// 	dfs = func(x, y int) {
// 		if x < 0 || x >= len(grid) || y < 0 || y >= len(grid[0]) {
// 			return
// 		}

// 		if grid[x][y] == '1' {
// 			grid[x][y] = '0'
// 			dfs(x-1, y)
// 			dfs(x+1, y)
// 			dfs(x, y-1)
// 			dfs(x, y+1)
// 		}
// 	}

// 	ans := 0
// 	for i, g := range grid {
// 		for j, v := range g {
// 			if v == '1' {
// 				dfs(i, j)
// 				ans++
// 			}
// 		}
// 	}

// 	return ans
// }

// bfs
func numIslands(grid [][]byte) int {
	dir := [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}

	var bfs func(x, y int)
	bfs = func(x, y int) {
		queue := make([][2]int, 0)
		queue = append(queue, [2]int{x, y})
		grid[x][y] = '0'

		for len(queue) > 0 {
			cur := queue[0]
			queue = queue[1:]
			for i := 0; i < 4; i++ {
				nx, ny := cur[0]+dir[i][0], cur[1]+dir[i][1]
				if nx < 0 || nx >= len(grid) || ny < 0 || ny >= len(grid[0]) || grid[nx][ny] != '1' {
					continue
				}
				grid[nx][ny] = '0'
				queue = append(queue, [2]int{nx, ny})
			}
		}
	}

	ans := 0
	for i, g := range grid {
		for j, v := range g {
			if v == '1' {
				bfs(i, j)
				ans++
			}
		}
	}

	return ans
}
