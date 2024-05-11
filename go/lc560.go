package main

func subarraySum(nums []int, k int) int {
	pre, pm, ans := 0, make(map[int]int, 0), 0
	pm[0] = 1
	for _, num := range nums {
		pre += num
		ans += pm[pre-k]
		pm[pre]++
	}
	return ans
}
