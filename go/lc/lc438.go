package main

func findAnagrams(s string, p string) []int {
	cnt := make([]int, 26)
	for _, v := range p {
		cnt[v-'a']++
	}
	res, l, r, curLen := make([]int, 0), 0, 0, 0
	for l <= r && r < len(s) {
		if cnt[s[r]-'a'] > 0 {
			cnt[s[r]-'a']--
			curLen++
			if curLen == len(p) {
				res = append(res, l)
				cnt[s[l]-'a']++
				l++
				curLen--
			}
			r++
		} else {
			for l < r && s[l] != s[r] {
				curLen--
				cnt[s[l]-'a']++
				l++
			}
			l++
			r++
		}
	}
	return res
}

