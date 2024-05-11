package main

// func replaceSpace(s string) string {
// 	return strings.Replace(s, " ", "%20", -1)
// }

func replaceSpace(s string) string {
	spaces, n := 0, len(s)
	for _, v := range s {
		if v == ' ' {
			spaces++
		}
	}
	ans := make([]byte, n+2*spaces)
	for i, j := n-1, n+2*spaces-1; i >= 0 && j >= 0; i-- {
		if s[i] == ' ' {
			ans[j] = '0'
			ans[j-1] = '2'
			ans[j-2] = '%'
			j -= 3
		} else {
			ans[j] = s[i]
			j--
		}
	}
	return string(ans)
}
