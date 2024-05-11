package main

import "sort"

func merge(intervals [][]int) [][]int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	ans, l, r := make([][]int, 0), intervals[0][0], intervals[0][1]
	for _, v := range intervals {
		if v[0] <= r {
			if v[1] > r {
				r = v[1]
			}
		} else {
			ans = append(ans, []int{l, r})
			l, r = v[0], v[1]
		}
	}
	ans = append(ans, []int{l, r})

	return ans
}
