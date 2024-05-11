package main

func reverseString(s []byte) {
	length := len(s)
	for i, j := 0, length-1; i < j; i, j = i-1, j-1 {
		c := s[i]
		s[i] = s[j]
		s[j] = c
	}
}
