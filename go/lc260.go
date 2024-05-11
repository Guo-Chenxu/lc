package main

func singleNumber(nums []int) []int {
	num := 0
	for _, v := range nums {
		num ^= v
	}
	num = num & (-num)

	ans := make([]int, 2)
	for _, v := range nums{
		if num & v == 0{
			ans[0] ^= v
		}else{
			ans[1] ^= v
		}
	}

	return ans
}
