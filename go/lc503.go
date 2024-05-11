package main

func nextGreaterElements(nums []int) []int {
	n := len(nums)
	stack, ans := make([]int, n), make([]int, n)
	for i := range ans {
		ans[i] = -1
	}

	for cnt := 0; cnt < 2; cnt++ {
		for i := 0; i < n; i++ {
			for len(stack) > 0 && nums[i] > nums[stack[len(stack)-1]] {
				ans[stack[len(stack)-1]] = nums[i]
				stack = stack[:len(stack)-1]
			}
			stack = append(stack, i)
		}
	}

	return ans
}
