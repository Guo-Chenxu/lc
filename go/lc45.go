package main

func jump(nums []int) int {
	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	curMaxdis, nexMaxDis, ans := 0, nums[0], 0
	for i := 0; i < len(nums); i++ {
		if curMaxdis >= len(nums)-1 {
			break
		}
		nexMaxDis = max(nexMaxDis, i+nums[i])
		if i == curMaxdis {
			curMaxdis = nexMaxDis
			ans++
		}
	}
	return ans
}
