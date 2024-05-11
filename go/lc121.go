package main

func maxProfit(prices []int) int {
	res, sub := 0, 0
	for i := 1; i < len(prices); i++ {
		sub += prices[i] - prices[i-1]
		if sub < 0 {
			sub = 0
		} else if sub > res {
			res = sub
		}
	}

	return res
}
