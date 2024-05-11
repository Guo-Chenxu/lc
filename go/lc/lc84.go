package main

func largestRectangleArea(heights []int) int {
	stack := make([]int, 0)
	stack = append(stack, -1)

	left, right := make([]int, len(heights)), make([]int, len(heights))
	for i := range right {
		right[i] = len(heights)
	}

	for i, h := range heights {
		for len(stack) > 1 && h < heights[stack[len(stack)-1]] {
			right[stack[len(stack)-1]] = i
			stack = stack[:len(stack)-1]
		}
		left[i] = stack[len(stack)-1]
		stack = append(stack, i)
	}

	ans := 0
	for i, h := range heights {
		if (right[i]-left[i]-1)*h > ans {
			ans = (right[i] - left[i] - 1) * h
		}
	}

	return ans
}
