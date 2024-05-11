package main

func letterCombinations(digits string) []string {
	var phone = [][]rune{{}, {},
		{'a', 'b', 'c'},
		{'d', 'e', 'f'},
		{'g', 'h', 'i'},
		{'j', 'k', 'l'},
		{'m', 'n', 'o'},
		{'p', 'q', 'r', 's'},
		{'t', 'u', 'v'},
		{'w', 'x', 'y', 'z'},
	}
	res, length := make([]string, 0), len(digits)
	if length == 0 {
		return res
	}
	nums := make([]int, length)
	for i, v := range digits {
		nums[i] = int(v - '0')
	}

	var dfs func(k, r int, path []rune)
	dfs = func(k, r int, path []rune) {
		if k == 0 {
			res = append(res, string(path))
			return
		}

		// 还需要有 k 个元素, 当前位置是第 r 个数字的第 j 个字母
		for j := 0; j < len(phone[nums[r]]); j++ {
			path = append(path, phone[nums[r]][j])
			dfs(k-1, r+1, path)
			path = path[:len(path)-1]
		}
	}

	dfs(length, 0, []rune{})
	return res
}
