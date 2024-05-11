package main

// // dp
// func countSubstrings(s string) int {
// 	n := len(s)
// 	dp := make([][]bool, n)
// 	for i := range dp {
// 		dp[i] = make([]bool, n)
// 	}

// 	ans := 0
// 	for i := n - 1; i >= 0; i-- {
// 		for j := i; j < n; j++ {
// 			if s[i] == s[j] && (j-i <= 1 || dp[i+1][j-1]) {
// 				dp[i][j] = true
// 				ans++
// 			}
// 		}
// 	}

// 	return ans
// }

// 双指针法
func countSubstrings(s string) int {
	count := func(l, r int) int {
		res := 0

		for l >= 0 && r < len(s) && s[l] == s[r] {
			res++
			l--
			r++
		}

		return res
	}

	ans := 0

	for i := range s {
		ans += count(i, i)
		ans += count(i, i+1)
	}

	return ans
}
