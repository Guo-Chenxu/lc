package main

func nextGreaterElement(nums1 []int, nums2 []int) []int {
	n, idx := len(nums2), 0
	idxMap, stack := make(map[int]int, 0), make([]int, 0)

	for i := 0; i < n; i++ {
		for idx > 0 && nums2[i] > nums2[stack[idx-1]] {
			idxMap[nums2[stack[idx-1]]] = nums2[i]
			stack = stack[:idx-1]
			idx--
		}
		stack = append(stack, i)
		idx++
	}

	ans := make([]int, len(nums1))
	for i, num := range nums1 {
		if v, ok := idxMap[num]; ok && v != 0 {
			ans[i] = v
		} else {
			ans[i] = -1
		}
	}

	return ans
}
