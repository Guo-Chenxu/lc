package main

func majorityElement(nums []int) int {
	res, cnt := nums[0], 0
	for _, v := range nums {
		if cnt == 0 {
			res = v
		}
		if v == res {
			cnt++
		} else {
			cnt--
		}
	}
	return res
}
