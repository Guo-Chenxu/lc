package main

func coinChange(coins []int, amount int) int {
	if amount == 0 {
		return 0
	}

	dp := make([]int, amount+1)

	for i := 1; i <= amount; i++ {
		dp[i] = amount + amount
	}

	for _, c := range coins {
		for i := c; i <= amount; i++ {
			if dp[i-c]+1 < dp[i] {
				dp[i] = dp[i-c] + 1
			}
		}
	}

	if dp[amount] == amount+amount {
		return -1
	}
	return dp[amount]
}
