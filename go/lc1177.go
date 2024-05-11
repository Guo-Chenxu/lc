package main

import "math/bits"

func canMakePaliQueries(s string, queries [][]int) []bool {
	res := make([]bool, len(queries))
	cnt := make([]int, len(s)+1)
	for i, v := range s {
		cnt[i+1] = cnt[i] ^ (1 << (v - 'a'))
	}
	for i, q := range queries {
		// x, num := cnt[q[1]+1]^cnt[q[0]], 0
		// for x > 0 {
		// 	x &= (x - 1)
		// 	num++
		// }
		num := bits.OnesCount(uint(cnt[q[1]+1] ^ cnt[q[0]]))
		res[i] = (num/2 <= q[2])
	}
	return res
}
