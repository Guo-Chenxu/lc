package main

// dp太简单, 所以用优化的 贪心+二分 做
func lengthOfLIS(nums []int) int {
	ans, n := 1, len(nums)
	if n == 0 {
		return 0
	}

	d := make([]int, 0)
	d = append(d, nums[0])
	for i := 1; i < n; i++ {
		if nums[i] > d[ans-1] {
			d = append(d, nums[i])
			ans++
		} else {
			m := func(l, r int) int {
				for l <= r {
					m := ((l + r) >> 1)
					if d[m] < nums[i] {
						l = m + 1
					} else if d[m] > nums[i] {
						r = m - 1
					} else {
						return m
					}
				}
				return l
			}(0, ans)
			d[m] = nums[i]
		}
	}

	return ans
}
