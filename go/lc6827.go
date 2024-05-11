package main

func minimumIndex(nums []int) int {
	cnt := make(map[int]int, 0)
	n, t := len(nums), 0
	maxNum, maxCnt := -1, -1
	for _, v := range nums {
		cnt[v]++
	}
	for k, v := range cnt {
		if v > (n >> 1) {
			maxNum = k
			maxCnt = v
		}
	}
	for i, v := range nums {
		if v == maxNum {
			t++
		}
		if t*2 > (i+1) && (maxCnt-t)*2 > (n-i-1) {
			return i
		}
	}
	return -1
}
