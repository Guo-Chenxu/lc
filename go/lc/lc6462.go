package main

func minimizedStringLength(s string) int {
	cnt := make([]byte, 26)
	for _, v := range s {
		cnt[v-'a']++
	}
	res := 0
	for _, v := range cnt {
		if v > 0 {
			res++
		}
	}
	return res
}
