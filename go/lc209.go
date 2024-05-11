package main

func minSubArrayLen(target int, nums []int) int {
	res, n := 0x7fffffff, len(nums)
	sum := 0
	min := func(a, b int) int {
		if a < b {
			return a
		}
		return b
	}
	for l, r := 0, 0; r < n; r++ {
		sum += nums[r]
		for sum >= target {
			res = min(res, r-l)
			sum -= nums[l]
			l++
		}
	}
	if res == 0x7fffffff {
		return 0
	}
	return res
}
