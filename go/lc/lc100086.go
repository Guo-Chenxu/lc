package main

func max(a, b int64) int64 {
	if a > b {
		return a
	}
	return b
}

func maximumTripletValue(nums []int) int64 {
	n := len(nums)
	lmax, rmax := make([]int64, n), make([]int64, n)

	lmax[0] = int64(nums[0])
	for i := 1; i < n; i++ {
		lmax[i] = max(lmax[i-1], int64(nums[i]))
	}
	rmax[n-1] = int64(nums[n-1])
	for i := n - 2; i >= 0; i-- {
		rmax[i] = max(rmax[i+1], int64(nums[i]))
	}

	var ans int64 = 0
	for j := 1; j < n-1; j++ {
		ans = max(ans, (lmax[j-1]-int64(nums[j]))*rmax[j+1])
	}

	return ans
}
