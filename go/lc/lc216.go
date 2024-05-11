package main

func combinationSum3(k int, n int) [][]int {
	res, vis := make([][]int, 0), make([]bool, 10)
	for i := 1; i <= 9; i++ {
		vis[i] = false
	}

	var dfs func(k, n, now, sum int, path []int)
	dfs = func(k, n, now, sum int, path []int) {
		if sum == n && k == 0 {
			temp := make([]int, len(path))
			copy(temp, path)
			res = append(res, temp)
			return
		}

		for i := now; i <= 9; i++ {
			if sum+i <= n {
				if !vis[i] {
					vis[i] = true
					path = append(path, i)
					dfs(k-1, n, i+1, sum+i, path)
					vis[i] = false
					path = path[:len(path)-1]
				}
			} else {
				return
			}
		}
	}

	dfs(k, n, 1, 0, []int{})
	return res
}
