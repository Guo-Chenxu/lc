package main

/**
 * 未优化
 */
// func applyOperations(nums []int) []int {
// 	n := len(nums)
// 	res := make([]int, n)
// 	cnt := 0
// 	for i := 0; i < n-1; i++ {
// 		if nums[i] != 0 {
// 			if nums[i] == nums[i+1] {
// 				nums[i] *= 2
// 				res[cnt] = nums[i]
// 				nums[i + 1] = 0
// 				cnt++
// 				i++
// 			} else {
// 				res[cnt] = nums[i]
// 				cnt++
// 			}
// 		}
// 	}
// 	if nums[n-1] != 0 {
// 		res[cnt] = nums[n-1]
// 	}
// 	return res
// }

/**
 * 优化
 * 原数组 + 双指针
 */
func applyOperations(nums []int) []int {
	n := len(nums)
	for i := 0; i < n-1; i++ {
		if nums[i] == nums[i+1] {
			nums[i] <<= 1
			nums[i+1] = 0
			i++
		}
	}
	j := 0
	for i := 0; i < n; i++ {
		if nums[i] != 0 {
			nums[j] = nums[i]
			j++
		}
	}
	for ; j < n; j++ {
		nums[j] = 0
	}
	return nums
}
