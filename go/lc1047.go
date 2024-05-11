package main

func removeDuplicates(s string) string {
	res := make([]rune, 0)
	for _, v := range s {
		n := len(res)
		if n > 0 && res[n-1] == v {
			res = res[:n-1]
		} else {
			res = append(res, v)
		}
	}
	return string(res)
}
