package main

func removeDuplicates(nums []int) int {
	n := len(nums)
	if n <= 1 {
		return n
	}

	i, j := 0, 1
	for ; j < n; j++ {
		for j < n && nums[j] == nums[i] {
			j++
		}
		if j < n {
			i++
			nums[i] = nums[j]
		}
	}

	return i + 1
}
