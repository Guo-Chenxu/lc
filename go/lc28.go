package main

func strStr(haystack string, needle string) int {
	getNext := func(pat string) []int {
		length, k := len(pat), -1
		next := make([]int, length)
		next[0] = k
		for i := 1; i < length; i++ {
			for k >= 0 && pat[i] != pat[k+1] {
				k = next[k]
			}
			if pat[i] == pat[k+1] {
				k++
			}
			next[i] = k
		}
		return next
	}

	kmp := func(str, pat string) int {
		next := getNext(pat)
		n, m := len(str), len(pat)
		for i, j := 0, -1; i < n; i++ {
			for j >= 0 && str[i] != pat[j+1] {
				j = next[j]
			}
			if str[i] == pat[j+1] {
				j++
			}
			if j == m-1 {
				return i - j
			}
		}
		return -1
	}

	return kmp(haystack, needle)
}

