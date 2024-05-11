package main

func findMiddleIndex(nums []int) int {
	sum := 0
	for _, v := range nums {
		sum += v
	}

	cur := 0
	for i, v := range nums {
		if sum == cur+cur+v {
			return i
		}
		cur += v
	}

	return -1
}
