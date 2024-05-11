package main

import "strconv"

func monotoneIncreasingDigits(n int) int {
	if n < 10 {
		return n
	}
	s := []byte(strconv.Itoa(n))
	idx := len(s)
	for i := len(s) - 1; i > 0; i-- {
		if s[i] < s[i-1] {
			idx = i
			s[i-1] = s[i-1]-1
		}
	}
	for i := idx; i < len(s); i++{
		s[i] = '9'
	}

	res, _ := strconv.Atoi(string(s))
	return res
}
