package main

import "math"

// func maxSubArray(nums []int) int {
// 	ans, sum := math.MinInt, 0
// 	l, r := 0, 0

// 	max := func(a, b int) int {
// 		if a > b {
// 			return a
// 		}
// 		return b
// 	}

// 	for r < len(nums) {
// 		sum += nums[r]
// 		r++
// 		ans = max(ans, sum)
// 		if sum < 0 {
// 			sum = 0
// 		}
// 		for l < r && sum < 0 {
// 			sum -= nums[l]
// 			l++
// 		}
// 	}

// 	return ans
// }

// 贪心
// func maxSubArray(nums []int) int {
// 	ans, sum := math.MinInt, 0

// 	max := func(a, b int) int {
// 		if a > b {
// 			return a
// 		}
// 		return b
// 	}

// 	for i := 0; i < len(nums); i++ {
// 		sum += nums[i]
// 		ans = max(ans, sum)
// 		if sum < 0 {
// 			sum = 0
// 		}
// 	}

// 	return ans
// }

// dp
func maxSubArray(nums []int) int {
	dp := make([]int, len(nums)+1)
	ans := math.MinInt

	for i := 1; i <= len(nums); i++ {
		dp[i] = func(a, b int) int {
			if a > b {
				return a
			}
			return b
		}(dp[i-1]+nums[i-1], nums[i-1])
		if dp[i] > ans {
			ans = dp[i]
		}
	}

	return ans
}
