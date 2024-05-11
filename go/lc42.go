package main

// 单调栈
// func trap(height []int) int {
// 	n, ans := len(height), 0
// 	stack := make([]int, n)

// 	min := func(a, b int) int {
// 		if a < b {
// 			return a
// 		}
// 		return b
// 	}

// 	for i := 0; i < n; i++ {
// 		for len(stack) > 0 && height[i] > height[stack[len(stack)-1]] {
// 			bottom := height[stack[len(stack)-1]]
// 			stack = stack[:len(stack)-1]
// 			if len(stack) <= 0 {
// 				break
// 			}
// 			h1 := height[stack[len(stack)-1]]
// 			ans += (min(h1, height[i]) - bottom) * (i - stack[len(stack)-1] - 1)
// 		}
// 		stack = append(stack, i)
// 	}

// 	return ans
// }

// dp
func trap(height []int) int {
	n := len(height)
	left, right := make([]int, n), make([]int, n)

	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	min := func(a, b int) int {
		if a < b {
			return a
		}
		return b
	}

	// 左扫一遍, 右扫一遍, 记录最大能接的雨水数量
	left[0] = height[0]
	for i := 1; i < n; i++ {
		left[i] = max(left[i-1], height[i])
	}
	right[n-1] = height[n-1]
	for i := n - 2; i >= 0; i-- {
		right[i] = max(right[i+1], height[i])
	}

	// 取最小的最大值减去高度
	ans := 0
	for i := 0; i < n; i++ {
		ans += min(left[i], right[i]) - height[i]
	}

	return ans
}
