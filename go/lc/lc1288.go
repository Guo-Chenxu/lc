package main

import "sort"

func removeCoveredIntervals(intervals [][]int) int {
	sort.Slice(intervals, func(i, j int) bool {
		if intervals[i][0] != intervals[j][0]{
			return intervals[i][0] < intervals[j][0]
		}else{
			return intervals[i][1] > intervals[j][1]
		}
	})

	n, ans := len(intervals), len(intervals)
	rmax := intervals[0][1]
	for i := 1; i < n; i++ {
		if intervals[i][1] <= rmax {
			ans--
		} else {
			rmax = intervals[i][1]
		}
	}

	return ans
}
