package main

func partition(s string) [][]string {
	isPalindrome := func(l, r int) bool {
		for l <= r {
			if s[l] != s[r] {
				return false
			}
			l++
			r--
		}
		return true
	}

	ans := make([][]string, 0)

	var dfs func(idx int, path []string)
	dfs = func(idx int, path []string) {
		if idx >= len(s) {
			temp := make([]string, len(path))
			copy(temp, path)
			ans = append(ans, temp)
			return
		}

		for i := idx; i < len(s); i++ {
			t := s[idx : i+1]
			if isPalindrome(idx, i) {
				path = append(path, t)
				dfs(i+1, path)
			}else{
				continue
			}
			if len(path) > 0 {
				path = path[:len(path)-1]
			}
		}
	}

	dfs(0, []string{})
	return ans
}
