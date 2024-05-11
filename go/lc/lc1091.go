package main

import "container/list"

func shortestPathBinaryMatrix(grid [][]int) int {
	if grid[0][0] == 1 {
		return -1
	}
	next := [][]int{{1, 1}, {1, -1}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, 1}, {-1, -1}}
	n := len(grid)
	q := list.New()
	q.PushBack([3]int{0, 0, 1})
	grid[0][0] = -1
	res := 0x7fffffff
	for q.Len() != 0 {
		now := q.Front().Value.([3]int)
		q.Remove(q.Front())
		x := now[0]
		y := now[1]
		step := now[2]
		if x == n-1 && y == n-1 {
			res = step
			break
		}
		for i := 0; i < 8; i++ {
			nx := x + next[i][0]
			ny := y + next[i][1]
			if nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0 {
				grid[nx][ny] = -1
				q.PushBack([3]int{nx, ny, step + 1})
			}
		}
	}
	if res == 0x7fffffff {
		return -1
	}
	return res
}
