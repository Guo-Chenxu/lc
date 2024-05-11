package main

func reverseStr(s string, k int) string {
	length := len(s)
	t := []byte(s)

	min := func(a, b int) int {
		if a < b {
			return a
		}
		return b
	}

	for i := 0; i*k < length; i += 2 {
		l, r := i*k, min(i*k+k-1, length-1)
		for l < r {
			c := t[l]
			t[l] = t[r]
			t[r] = c
			l--
			r++
		}
	}

	return string(t)
}
