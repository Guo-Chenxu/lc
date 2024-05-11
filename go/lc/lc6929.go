package main

import "sort"

func maximumBeauty(nums []int, k int) int {
	sort.Ints(nums)
	res, n := 0, len(nums)
	for i, j := 0, 0; j < n; i++ {
		for j < n && nums[j]-nums[i] <= 2*k {
			j++
		}
		if j-i > res {
			res = j - i
		}
	}
	return res
}
