package main

import "sort"

func largestSumAfterKNegations(nums []int, k int) int {
	abs := func(a int) int {
		if a < 0 {
			return -a
		}
		return a
	}

	sort.Slice(nums, func(i, j int) bool {
		return abs(nums[i]) > abs(nums[j])
	})

	ans := 0
	for i := 0; i < len(nums); i++ {
		if k > 0 && nums[i] < 0 {
			k--
			ans -= nums[i]
		} else {
			ans += nums[i]
		}
	}

	if (k & 1) == 0 {
		return ans
	} else {
		return ans - 2*abs(nums[len(nums)-1])
	}
}
