package main

// 01 背包
// func canPartition(nums []int) bool {
// 	sum := 0
// 	for _, v := range nums {
// 		sum += v
// 	}

// 	if (sum & 1) == 0 {
// 		sum = (sum >> 1)
// 	} else {
// 		return false
// 	}

// 	dp := make([]int, sum+1)
// 	for i := 0; i < len(nums); i++ {
// 		n := nums[i]
// 		for j := sum; j >= n; j-- {
// 			if dp[j-n]+n > dp[j] {
// 				dp[j] = dp[j-n] + n
// 			}
// 		}
// 	}

// 	return dp[sum] == sum
// }

func canPartition(nums []int) bool {
	sum, n := 0, len(nums)
	for _, v := range nums {
		sum += v
	}

	if (sum & 1) != 0 {
		return false
	}
	sum >>= 1

	dp := make([]int, sum+1)
	for i := 0; i < n; i++ {
		for j := sum; j >= nums[i]; j-- {
			if dp[j-nums[i]]+nums[i] > dp[j] {
				dp[j] = dp[j-nums[i]] + nums[i]
			}
		}
	}

	return dp[sum] == sum
}
