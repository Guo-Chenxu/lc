package main

func numSmallerByFrequency(queries []string, words []string) []int {
	f := func(s string) int {
		t := 'z'
		n := 0
		for _, c := range s {
			if c < t {
				t = c
				n = 1
			} else if c == t {
				n++
			}
		}
		return n
	}

	count := make([]int, 12)
	for _, s := range words {
		count[f(s)]++
	}

	for i := 9; i >= 1; i-- {
		count[i] += count[i+1]
	}

	res := make([]int, len(queries))
	for i, s := range queries {
		res[i] = count[f(s)+1]
	}
	return res
}
