package main

import "strconv"

func evalRPN(tokens []string) int {
	nums := make([]int, 0)
	for _, v := range tokens {
		n := len(nums)
		if t, err := strconv.Atoi(v); err == nil {
			nums = append(nums, t)
		} else {
			a, b := nums[n-1], nums[n-2]
			nums = nums[:n-2]
			switch v {
			case "+":
				nums = append(nums, a+b)
			case "-":
				nums = append(nums, a-b)
			case "*":
				nums = append(nums, a*b)
			case "/":
				nums = append(nums, a/b)
			}
		}
	}
	return nums[0]
}
