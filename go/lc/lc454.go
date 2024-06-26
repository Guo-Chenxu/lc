package main

func fourSumCount(nums1 []int, nums2 []int, nums3 []int, nums4 []int) int {
	m := make(map[int]int, 0)
	for _, n1 := range nums1 {
		for _, n2 := range nums2 {
			m[n1+n2]++
		}
	}
	res := 0
	for _, n3 := range nums3 {
		for _, n4 := range nums4 {
			res += m[(0 - n3 - n4)]
		}
	}
	return res
}
