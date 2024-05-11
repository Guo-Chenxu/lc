package main

// 转换成分成两个最相同的堆
func lastStoneWeightII(stones []int) int {
	sum, n := 0, len(stones)

	for _, v := range stones {
		sum += v
	}

	target := ((sum + 1) >> 1)
	dp := make([]int, target+1)
	for i := 0; i < n; i++ {
		for j := target; j >= stones[i]; j-- {
			if dp[j-stones[i]]+stones[i] > dp[j] {
				dp[j] = dp[j-stones[i]] + stones[i]
			}
		}
	}

	ans := sum - dp[target] - dp[target]
	if ans < 0 {
		return -ans
	}
	return ans
}
