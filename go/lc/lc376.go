package main

func wiggleMaxLength(nums []int) int {
	if len(nums) == 1 {
		return 1
	}

	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}
		
	up, down := 1, 1
	for i := 1; i < len(nums); i++ {
		if nums[i] > nums[i-1] {
			up = max(up, down+1)
		} else if nums[i] < nums[i-1] {
			down = max(down, up+1)
		}
	}
	
	return max(up, down)
}
