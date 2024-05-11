package main

import (
	"sort"
)

func miceAndCheese(reward1 []int, reward2 []int, k int) int {
	n := len(reward1)
	res := 0
	for i := 0; i < n; i++ {
		res += reward2[i]
		reward1[i] = reward2[i] - reward1[i]
	}
	sort.Ints(reward1)
	for i := 0; i < k; i++{
		res += reward1[i]
	}
	return res
}
