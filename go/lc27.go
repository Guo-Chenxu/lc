package main

func removeElement(nums []int, val int) int {
	j := 0
	for _, v := range nums{
		if v != val{
			nums[j] = v
			j++
		}
	}	
	return j
}