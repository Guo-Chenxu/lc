package main

func numTimesAllBlue(flips []int) int {
	now, res := 0, 0
	for i, v := range flips {
		if v > now {
			now = v
		}
		if now == i+1 {
			res++
		}
	}
	return res
}
