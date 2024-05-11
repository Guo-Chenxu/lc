package main

import (
	"strconv"
)

func restoreIpAddresses(s string) []string {
	// 判断ip是否有效
	check := func(l, r int) bool {
		if l >= len(s) || l > r {
			return false
		}
		if s[l] == '0' {
			if l == r {
				return true
			}
			return false
		} else {
			num, err := strconv.Atoi(s[l : r+1])
			if err != nil {
				return false
			}
			return num <= 255
		}
	}

	ans := make([]string, 0)
	var dfs func(idx, n int, path string)
	dfs = func(idx, n int, path string) {
		if n == 3 {
			if check(idx, len(s)-1) {
				temp := path + s[idx:]
				ans = append(ans, temp)
			}
			return
		}

		for i := idx; i < len(s); i++ {
			if check(idx, i) {
				path = path + s[idx:i+1] + "."
				dfs(i+1, n+1, path)
			} else {
				continue
			}
			path = path[:len(path)-(i+1-idx)-1]
		}
	}

	dfs(0, 0, "")
	return ans
}
