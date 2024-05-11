package main

import (
	"math"
	"sort"
)

func maximumTastiness(price []int, k int) int {
	sort.Ints(price)
	left, right := 0, price[len(price)-1]-price[0]
	check := func(price []int, mid, k int) bool {
		pre := int(math.Inf(-1)) >> 1
		cnt := 0
		for _, v := range price {
			if v-pre >= mid {
				cnt++
				pre = v
			}
		}
		return cnt >= k
	}
	for left < right {
		mid := (right + left + 1) / 2
		if check(price, mid, k) {
			left = mid
		} else {
			right = mid - 1
		}
	}
	return left
}
