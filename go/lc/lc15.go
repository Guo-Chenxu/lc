package main

import "sort"

func threeSum(nums []int) [][]int {
	res := make([][]int, 0)
	sort.IntSlice.Sort(nums)
	length := len(nums)

	if nums[0] > 0 || nums[length-1] < 0 {
		return res
	}

	for fi := 0; fi < length; fi++ {
		if fi > 0 && nums[fi] == nums[fi-1] {
			continue
		}
		th := length - 1
		for se := fi + 1; se < length; se++ {
			if se > fi+1 && nums[se] == nums[se-1] {
				continue
			}
			for se < th && nums[fi]+nums[se]+nums[th] > 0 {
				th--
			}
			if se < th && nums[fi]+nums[se]+nums[th] == 0 {
				tmp := []int{nums[fi], nums[se], nums[th]}
				res = append(res, tmp)
			}
		}
	}

	return res
}
