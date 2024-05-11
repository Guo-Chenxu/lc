package main

import (
	"math"
)

// todo

func zeroOnePackCount(v, nums int, value []int) int64 {
	dp := make([]int64, v+1)
	dp[0] = 1
	for j := 0; j < nums; j++ {
		for i := v; i >= 0; i-- {
			if i >= value[j] {
				dp[i] = dp[i] + dp[i-value[j]]
			}
			dp[i] = dp[i] % (1e9 + 7)
		}
	}
	return dp[v]
}

func numberOfWays(n int, x int) int {
	max := int(math.Pow(float64(n), 1.0/float64(x))) + 2
	nums := make([]int, max)
	for i := 1; i <= max; i++ {
		nums[i-1] = int(math.Pow(float64(i), float64(x)))
	}
	return int(zeroOnePackCount(n, max, nums))
}
