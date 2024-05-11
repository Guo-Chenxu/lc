package main

func maxSlidingWindow(nums []int, k int) []int {
	length := len(nums)
	res, deque := make([]int, 0), make([]int, 0)

	update := func(deque *[]int, num int) {
		for len(*deque) > 0 && (*deque)[len(*deque)-1] < num {
			(*deque) = (*deque)[:len(*deque)-1]
		}
		if len(*deque) > 0 && (*deque)[len(*deque)-1] >= num {
			*deque = append(*deque, num)
		} else if len(*deque) == 0 {
			*deque = append(*deque, num)
		}
	}

	for i := 0; i < k; i++ {
		update(&deque, nums[i])
	}
	res = append(res, deque[0])
	for i := k; i < length; i++ {
		if nums[i-k] == deque[0] {
			deque = deque[1:]
		}
		update(&deque, nums[i])
		res = append(res, deque[0])
	}
	return res
}
