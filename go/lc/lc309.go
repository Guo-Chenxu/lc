package main

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/solutions/323509/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
func maxProfit(prices []int) int {
	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	// 1 买入股票
	// 2 可以卖出
	// 3 冷冻期
	dp := make([][4]int, len(prices))
	dp[0][1] = -prices[0]
	for i := 1; i < len(prices); i++ {
		dp[i][1] = max(dp[i-1][1], dp[i-1][2]-prices[i])
		dp[i][2] = max(dp[i-1][2], dp[i-1][3])
		dp[i][3] = dp[i-1][1] + prices[i]
	}

	return max(dp[len(prices)-1][2], dp[len(prices)-1][3])
}
