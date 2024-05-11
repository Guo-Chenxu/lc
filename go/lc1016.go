package main

import (
	"strconv"
	"strings"
)

func queryString(s string, n int) bool {
	for i := 1; i <= n; i++ {
		if !strings.Contains(s, strconv.FormatUint(uint64(i), 2)) {
			return false
		}
	}
	return true
}

func queryString01(s string, n int) bool {
	seen := make(map[int]int, 0)
	length := len(s)
	for i, b := range s {
		if b == '0' {
			continue
		}
		num := 0
		for j := i; j < length; j++ {
			num = (num << 1) | (int(s[j] - '0'))
			if num > n {
				break
			}
			seen[num] = 1
		}
	}
	return len(seen) == n
}
