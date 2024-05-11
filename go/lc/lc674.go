package main

func findLengthOfLCIS(nums []int) int {
	ans := 1
	for i := 1; i < len(nums); i++ {
		t := 1
		for i < len(nums) && nums[i] > nums[i-1] {
			t++
			i++
		}
		if t > ans {
			ans = t
		}
	}

	return ans
}
