package main

func combine(n int, k int) [][]int {
	res := make([][]int, 0)
	var backtracking func(n, k, start int, path []int)
	backtracking = func(n, k, start int, path []int) {
		if k == 0 {
			temp := make([]int, len(path))
			copy(temp, path)
			res = append(res, temp)
			return
		}
		for i := start; i <= n-k+1; i++ {
			path = append(path, i)
			backtracking(n, k-1, i+1, path)
			path = path[:len(path)-1]
		}
	}

	backtracking(n, k, 1, []int{})	
	return res
}
