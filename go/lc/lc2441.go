package main

import "math"

func findMaxK(nums []int) int {
	has := make([]bool, 2001)
	res := 0
	for _, i := range nums {
		has[i+1000] = true
		if has[1000-i] {
			res = int(math.Max(float64(res), math.Abs(float64(i))))
		}
	}
	if res == 0 {
		return -1
	} else {
		return res
	}
}

func findMaxK01(nums []int) int {
	has := make(map[int]int)
	res := 0
	for _, i := range nums {
		has[i] = 1
		if _, ok := has[i]; ok {
			res = int(math.Max(float64(res), math.Abs(float64(i))))
		}
	}
	if res == 0 {
		return -1
	} else {
		return res
	}
}
