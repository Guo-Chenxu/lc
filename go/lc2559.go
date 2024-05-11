package main

func vowelStrings(words []string, queries [][]int) []int {
	presum := make([]int, len(words)+1)
	check := func(c byte) bool {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
	}
	for i, str := range words {
		presum[i+1] = presum[i]
		if check(str[0]) && check(str[len(str)-1]) {
			presum[i+1]++
		}
	}
	res := make([]int, len(queries))
	for i, v := range queries {
		res[i] = presum[v[1]+1] - presum[v[0]]
	}
	return res
}
