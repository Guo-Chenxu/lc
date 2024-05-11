package main

func maxNonDecreasingLength(nums1 []int, nums2 []int) int {
	ans, n := 1, len(nums1)
	f0, f1 := 0, 0

	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	for i := 1; i < n; i++ {
		f, g := 1, 1
		if nums1[i] >= nums1[i-1] {
			f = f0 + 1
		}
		if nums1[i] >= nums2[i-1] {
			f = max(f, f1+1)
		}
		if nums2[i] >= nums2[i-1] {
			g = f1 + 1
		}
		if nums2[i] >= nums1[i-1] {
			g = max(g, f0+1)
		}
		f0, f1 = f, g
		ans = max(ans, max(f, g))
	}
	return ans
}
