package main

import "sort"

func sortVowels(s string) string {
	ok := func(v rune) bool {
		return v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u' || v == 'A' || v == 'E' || v == 'I' || v == 'O' || v == 'U'
	}

	n := len(s)
	cs := make([]int, 0)
	for _, v := range s {
		if ok(v) {
			cs = append(cs, int(v))
		}
	}
	sort.Ints(cs)
	res := make([]byte, 0)
	j := 0
	for i := 0; i < n; i++ {
		if !ok(rune(s[i])) {
			res = append(res, s[i])
		} else {
			res = append(res, byte(cs[j]))
			j++
		}
	}
	return string(res)
}
