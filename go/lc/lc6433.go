package main

import (
	"container/list"
	"math"
)

func ok(m, n, x, y int) bool {
	return x >= 0 && x < m && y >= 0 && y < n
}

func maxMoves(grid [][]int) int {
	moves := 0
	m := len(grid)
	n := len(grid[0])
	vis := make([][]int, m)
	for i := range vis {
		vis[i] = make([]int, n)
	}
	queue := list.New()
	for i := 0; i < m; i++ {
		queue.PushBack([3]int{i, 0, 0})
		vis[i][0] = 0
	}
	step := [3][2]int{{1, 1}, {0, 1}, {-1, 1}}
	for queue.Len() > 0 {
		now := queue.Front().Value.([3]int)
		queue.Remove(queue.Front())
		for _, s := range step {
			nx := now[0] + s[0]
			ny := now[1] + s[1]
			if ok(m, n, nx, ny) && grid[nx][ny] > grid[now[0]][now[1]] {
				if now[2]+1 > vis[nx][ny] {
					queue.PushBack([3]int{nx, ny, now[2] + 1})
					vis[nx][ny] = now[2] + 1
				}
			} else {
				moves = int(math.Max(float64(moves), float64(now[2])))
			}
		}
	}
	return moves
}
