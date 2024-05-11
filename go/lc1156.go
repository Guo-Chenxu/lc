package main

func MaxRepOpt1(text string) int {
	max := func(a, b int) int {
		if a >= b {
			return a
		}
		return b
	}
	min := func(a, b int) int {
		if a >= b {
			return b
		}
		return a
	}
	cnt := make([]int, 26)
	for _, v := range text {
		cnt[v-'a']++
	}
	length := len(text)
	res := 0
	for i := 0; i < length; {
		j := i + 1
		for j < length && text[j] == text[i] {
			j++
		}
		curCnt := j - i
		if curCnt < cnt[text[i]-'a'] && (j < length || i > 0) {
			res = max(res, curCnt)
		}
		k := j + 1
		for k < length && text[k] == text[i] {
			k++
		}
		res = max(res, min(k-i, cnt[text[i]-'a']))
		i = j
	}
	return res
}
