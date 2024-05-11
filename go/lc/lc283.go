package main

func moveZeroes(nums []int) {
	for i, j := 0, 0; j < len(nums); j++ {
		if nums[j] != 0 {
			nums[i] = nums[j]
			if i != j {
				nums[j] = 0
			}
			i++
		}
	}
}
