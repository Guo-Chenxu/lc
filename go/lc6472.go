package main

func matrixSumQueries(n int, queries [][]int) int64 {
	qn := len(queries)
	row, col := make([]bool, n), make([]bool, n)
	rown, coln := n, n
	cnt := n * n
	var res int64 = 0
	for i := qn - 1; i >= 0 && cnt > 0; i-- {
		op := queries[i][0]
		idx := queries[i][1]
		num := queries[i][2]
		if op == 0 {
			if !row[idx] {
				row[idx] = true
				res = res + int64(num*rown)
				coln--
			}
		} else {
			if !col[idx] {
				col[idx] = true
				res = res + int64(num*coln)
				rown--
			}
		}
	}
	return res
}
