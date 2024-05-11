package main

import "sort"

func findMinArrowShots(points [][]int) int {
	sort.Slice(points, func(i, j int) bool {
		return points[i][0] < points[j][0]
	})

	ans, r := 0, points[0][1]
	for _, p := range points {
		if p[0] <= r {
			if p[1] < r {
				r = p[1]
			}
		} else {
			ans++
			r = p[1]
		}
	}

	return ans + 1
}
