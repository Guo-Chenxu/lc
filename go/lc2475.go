package main

func unequalTriplets(nums []int) int {
	cnt := make(map[int]int)
	for _, num := range nums {
		cnt[num]++
	}
	l, n, res := 0, len(nums), 0
	for _, v := range cnt {
		res += l * v * (n - l - v)
		l += v
	}
	return res
}
