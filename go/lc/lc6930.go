package main

import "sort"

func isGood(nums []int) bool {
	sort.Ints(nums)
	n := len(nums)
	if n < 2 {
		return false
	}
	for i := 0; i < n-1; i++ {
		if i+1 != nums[i] {
			return false
		}
	}
	if nums[n-1] == nums[n-2] && nums[n-1] == n-1 {
		return true
	}
	return false
}
