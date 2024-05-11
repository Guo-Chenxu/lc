package main

func sortedSquares(nums []int) []int {
	n := len(nums)
	res := make([]int, n)
	i, j, k := 0, n-1, n-1
	for k >= 0 {
		x, y := nums[i]*nums[i], nums[j]*nums[j]
		if x < y {
			res[k] = y
			j--
		} else {
			res[k] = x
			i++
		}
		k--
	}
	return res
}
