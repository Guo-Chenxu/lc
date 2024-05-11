package main

import "sort"

func topKFrequent(nums []int, k int) []int {
	m := make(map[int]int, 0)
	for _, v := range nums {
		m[v]++
	}
	ans := make([]int, 0)
	for k := range m {
		ans = append(ans, k)
	}
	sort.Slice(ans, func(i, j int) bool {
		return m[ans[i]] > m[ans[j]]
	})
	return ans[:k]
}
