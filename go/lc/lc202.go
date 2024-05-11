package main

func isHappy(n int) bool {
	getSum := func(x int) int {
		res := 0
		for x != 0 {
			t := x % 10
			res += t * t
			x /= 10
		}
		return res
	}
	cnt := make(map[int]int, 0)
	for n != 1 {
		cnt[n]++
		n = getSum(n)
		if _, ok := cnt[n]; ok {
			break
		}
	}
	return n == 1
}
