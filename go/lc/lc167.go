package main

func twoSum(numbers []int, target int) []int {
	i, j := 0, len(numbers)
	for i < j {
		if numbers[i]+numbers[j] == target {
			return []int{i + 1, j + 1}
		} else if numbers[i]+numbers[j] < target {
			i++
		} else {
			j--
		}
	}
	return []int{}
}
