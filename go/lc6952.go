package main

func countInterestingSubarrays(nums []int, modulo int, k int) int64 {
	cnt, cntMap := 0, make(map[int]int, 0)
	cntMap[0] = 1
	var res int64 = 0
	for _, v := range nums {
		if v%modulo == k {
			cnt++
		}
		res += int64(cntMap[(cnt%modulo-k+modulo)%modulo])
		cntMap[cnt%modulo]++
	}
	return int64(res)
}
