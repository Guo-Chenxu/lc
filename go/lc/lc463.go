package main

// // bfs, 但是想复杂了
// func islandPerimeter(grid [][]int) int {
// 	dir := [4][2]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}

// 	bfs := func(i, j int) int {
// 		queue := make([][2]int, 0)
// 		m, n, res := len(grid), len(grid[0]), 0
// 		queue = append(queue, [2]int{i, j})

// 		for len(queue) > 0 {
// 			cur := queue[0]
// 			queue = queue[1:]
// 			grid[cur[0]][cur[1]] = -1

// 			for _, v := range dir {
// 				nx := cur[0] + v[0]
// 				ny := cur[1] + v[1]
// 				if nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0 {
// 					res++
// 				} else if grid[nx][ny] == 1 {
// 					queue = append(queue, [2]int{nx, ny})
// 				}
// 			}
// 		}

// 		return res
// 	}

// 	for i, g := range grid {
// 		for j, v := range g {
// 			if v == 1 {
// 				return bfs(i, j)
// 			}
// 		}
// 	}

// 	return 0
// }

// 直接遍历就行
func islandPerimeter(grid [][]int) int {
	ans, m, n := 0, len(grid), len(grid[0])

	dir := [4][2]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}

	for i, g := range grid {
		for j, v := range g {
			if v == 1 {
				for _, k := range dir {
					nx, ny := i+k[0], j+k[1]
					if nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0 {
						ans++
					}
				}
			}
		}
	}

	return ans
}
