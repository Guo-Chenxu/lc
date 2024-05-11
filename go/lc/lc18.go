package main

import "sort"

func fourSum(nums []int, target int) [][]int {
	res := make([][]int, 0)
	sort.Ints(nums)
	length := len(nums)

	for fi := 0; fi < length; fi++ {
		if nums[fi] > target && nums[fi] >= 0 {
			break
		}
		if fi > 0 && nums[fi] == nums[fi-1] {
			continue
		}
		for se := fi + 1; se < length; se++ {
			if nums[fi]+nums[se] > target && nums[fi]+nums[se] >= 0 {
				break
			}
			if se > fi+1 && nums[se] == nums[se-1] {
				continue
			}

			th, fo := se+1, length-1
			for th < fo {
				tmp := nums[fi] + nums[se] + nums[th] + nums[fo]
				if tmp > target {
					fo--
				} else if tmp < target {
					th++
				} else {
					t := []int{nums[fi], nums[se], nums[th], nums[fo]}
					res = append(res, t)
					for th < fo && nums[th] == nums[th+1] {
						th++
					}
					for th < fo && nums[fo-1] == nums[fo] {
						fo--
					}
					th++
					fo--
				}
			}
		}
	}
	return res
}
