package main

func removeDuplicates(nums []int) int {
	n := len(nums)
	if n <= 2 {
		return n
	}

	i, j := 0, 1
	for ; j < n; j++ {
		cnt, k := 0, nums[i]
		for j < n && nums[j] == k {
			j++
			if cnt < 1 {
				cnt++
				i++
				nums[i] = k
			}
		}
		if j < n {
			i++
			nums[i] = nums[j]
		}
	}

	return i + 1
}
