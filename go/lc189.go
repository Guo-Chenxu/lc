package main

func rotate(nums []int, k int) {
	k = k % (len(nums))

	swap := func(i, j int) {
		for i < j {
			t := nums[i]
			nums[i] = nums[j]
			nums[j] = t
			i++
			j--
		}
	}

	swap(0, len(nums)-1)
	swap(0, k-1)
	swap(k, len(nums)-1)
}
