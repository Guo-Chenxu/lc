package main

func twoSum(nums []int, target int) []int {
	res := make([]int, 2)
	hash := make(map[int]int, 0)
	for i, v := range nums {
		if idx, ok := hash[target-v]; ok {
			res[0] = idx
			res[1] = i
			break
		}
		hash[v] = i
	}
	return res
}
