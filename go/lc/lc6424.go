package main

func semiOrderedPermutation(nums []int) int {
	n := len(nums)
	if nums[0] == 0 && nums[n-1] == n {
		return 0
	}
	idx0, idxn := 0, 0
	for i, v := range nums {
		if v == 0 {
			idx0 = i
		} else if v == n {
			idxn = i
		}
	}
	res := idx0 + (n - 1 - idxn)
	if idx0 > idxn {
		res--
	}
	return res
}
