package main

func sumOfSquares(nums []int) int {
	sum, n := 0, len(nums)
	for i, v := range nums {
		if n%(i+1) == 0 {
			sum += (v * v)
		}
	}
	return sum
}
