package main

func averageValue(nums []int) int {
	sum, cnt := 0, 0
	for _, v := range nums {
		if v%6 == 0 {
			sum += v
			cnt++
		}
	}
	if cnt == 0 {
		return 0
	} else {
		return sum / cnt
	}
}
