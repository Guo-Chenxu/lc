package main

func generateMatrix(n int) [][]int {
	res := make([][]int, n)
	for i := 0; i < n; i++ {
		res[i] = make([]int, n)
	}
	offset, sx, sy := 1, 0, 0
	cnt, loop := 1, n>>1
	for ; loop > 0; loop-- {
		i, j := sx, sy
		for j < n-offset {
			res[i][j] = cnt
			cnt++
			j++
		}
		for i < n-offset {
			res[i][j] = cnt
			cnt++
			i++
		}
		for j >= offset {
			res[i][j] = cnt
			cnt++
			j--
		}
		for i >= offset {
			res[i][j] = cnt
			cnt++
			i--
		}
		sx++
		sy++
		offset++
	}
	if n&1 == 1 {
		res[n>>1][n>>1] = n * n
	}
	return res
}
