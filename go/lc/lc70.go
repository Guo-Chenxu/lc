package main

func climbStairs(n int) int {
	if n == 1 {
		return 1
	}
	a, b, ans := 1, 1, 0
	for i := 2; i <= n; i++ {
		ans = a + b
		a = b
		b = ans
	}
	return ans
}
