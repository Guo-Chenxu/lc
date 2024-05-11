package main

import "sort"

func distinctAverages(nums []int) int {
	sort.Ints(nums)
	n := len(nums)
	res := make(map[float32]int)
	for l, r := 0, n-1; l <= r; {
		avg := float32(nums[l]+nums[r]) / 2
		res[avg] = 1
		l++
		r--
	}
	return len(res)
}
