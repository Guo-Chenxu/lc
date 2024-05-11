package main

import (
	"math/rand"
)

func sortArray(nums []int) []int {
	var sort func(l, r int)
	sort = func(l, r int) {
		if l >= r {
			return
		}

		t := rand.Intn(r-l) + l
		nums[l], nums[t] = nums[t], nums[l]
		pivot := nums[l]
		i, j := l, r
		for i < j {
			for i < j && nums[j] >= pivot {
				j--
			}
			for i < j && nums[i] <= pivot {
				i++
			}
			if i < j {
				nums[i], nums[j] = nums[j], nums[i]
			}
		}
		nums[l], nums[i] = nums[i], nums[l]

		sort(l, j-1)
		sort(i+1, r)
	}

	sort(0, len(nums)-1)
	return nums
}
