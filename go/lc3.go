package main

func lengthOfLongestSubstring(s string) int {
	n, ans := len(s), 0

	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	m := make(map[byte]int)
	for i, j := 0, 0; j < n; {
		for j < n && m[s[j]] == 0 {
			m[s[j]]++
			j++
		}
		ans = max(ans, j-i)
		for i < j && j < n {
			m[s[i]]--
			i++
			if s[i-1] == s[j] {
				break
			}
		}
	}
	return ans
}
