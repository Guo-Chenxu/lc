package main

func findTargetSumWays(nums []int, target int) int {
	sum := 0
	for _, v := range nums {
		sum += v
	}

	if ((sum+target)&1) != 0 || (target > sum) || (-target > sum) {
		return 0
	}

	n := ((sum + target) >> 1)
	dp := make([]int, n+1)
	dp[0] = 1
	for i := 0; i < len(nums); i++ {
		for j := n; j >= nums[i]; j-- {
			// ! 如果是求总共有多少情况, 则直接累加
			dp[j] += dp[j-nums[i]]
		}
	}

	return dp[n]
}
