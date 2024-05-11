package main

func reverseLeftWords(s string, n int) string {
	length := len(s)
	str := []byte(s)

	reverse := func(s []byte, l, r int) []byte {
		for l < r {
			t := s[l]
			s[l] = s[r-1]
			s[r-1] = t
			l++
			r--
		}
		return s
	}

	str = reverse(str, 0, n)
	str = reverse(str, n, length)
	str = reverse(str, 0, length)
	return string(str)
}

// func reverseLeftWords(s string, n int) string {
// 	return s[n:] + s[0:n]
// }
