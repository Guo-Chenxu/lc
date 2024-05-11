package main

import "fmt"

func equalPairs(grid [][]int) int {
	n := len(grid)
	cnt := make(map[string]int)
	for _, row := range grid {
		cnt[fmt.Sprint(row)]++
	}
	res := 0
	for i := range grid {
		var a []int
		for j := 0; j < n; j++ {
			a = append(a, grid[j][i])
		}
		if val, ok := cnt[fmt.Sprint(a)]; ok {
			res += val
		}
	}
	return res
}
