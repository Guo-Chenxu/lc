package main

func longestCommonPrefix(strs []string) string {
	getCommon := func(a, b string) string {
		i := 0
		for i = 0; i < len(a) && i < len(b); i++ {
			if a[i] != b[i] {
				break
			}
		}
		return a[:i]
	}

	ans := strs[0]
	for _, v := range strs {
		ans = getCommon(ans, v)
	}

	return ans
}
