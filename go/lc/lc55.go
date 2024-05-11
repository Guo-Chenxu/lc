package main

func canJump(nums []int) bool {
	if len(nums) == 1{
		return true
	}

	maxDis := nums[0]
	for i := 0; i < maxDis; i++{
		if nums[i] + i >= len(nums) - 1{
			return true
		}
		if nums[i] + i > maxDis{
			maxDis = nums[i] + i
		}
	}
	return false
}
