package main

import "sort"

func eraseOverlapIntervals(intervals [][]int) int {
	if len(intervals) == 1 {
		return 0
	}

	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][1] < intervals[j][1]
	})

	l, r, ans := 0, 1, 0
	for r < len(intervals) {
		if intervals[r][0] < intervals[l][1] {
			ans++
		} else {
			l = r
		}
		r++
	}

	return ans
}
