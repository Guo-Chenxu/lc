package main

func dailyTemperatures(temperatures []int) []int {
	n, length := len(temperatures), 0
	ans, stack := make([]int, n), make([]int, 0)

	for i := 0; i < n; i++ {
		for length > 0 && temperatures[i] > temperatures[stack[length-1]] {
			ans[stack[length-1]] = i - stack[length-1]
			stack = stack[:length-1]
			length--
		}
		stack = append(stack, i)
		length++
	}

	return ans
}
