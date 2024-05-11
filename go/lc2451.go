package main

func oddString(words []string) string {
	m := make(map[[21]int][2]int)
	for i, s := range words {
		x := [21]int{}
		n := len(s)
		for i := 1; i < n; i++ {
			x[i] = int(s[i] - s[i-1])
		}
		t := m[x]
		t[0]++
		t[1] = i
		m[x] = t
	}
	for _, v := range m {
		if v[0] == 1 {
			return words[v[1]]
		}
	}
	return ""
}
