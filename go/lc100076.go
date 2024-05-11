package main

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func minSizeSubarray(nums []int, target int) int {
	n := len(nums)
	preSum := make([]int, n+1)
	for i := 1; i <= n; i++ {
		preSum[i] = preSum[i-1] + nums[i-1]
	}

	cnt := 1
	if (target/preSum[n] + 1) > 1 {
		cnt = target/preSum[n] + 1
	}

	for i := 0; i < cnt; i++ {
		t := make([]int, n+1)
		t[0] = preSum[(i+1)*n]
		for j := 1; j <= n; j++ {
			t[j] = t[j-1] + nums[j-1]
			preSum = append(preSum, t[j])
		}
	}

	ans, idxMap := 0x7fffffff, make(map[int]int, 0)
	for i, v := range preSum {
		if idx, ok := idxMap[v-target]; ok {
			ans = min(ans, i-idx)
		}
		idxMap[v] = i
	}

	if ans == 0x7fffffff {
		return -1
	}
	return ans
}
