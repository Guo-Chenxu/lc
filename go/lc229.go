package main

func majorityElement(nums []int) []int {
	num1, num2, cnt1, cnt2 := -1, -1, 0, 0
	for _, v := range nums {
		if cnt1 > 0 && num1 == v {
			cnt1++
		} else if cnt2 > 0 && num2 == v {
			cnt2++
		} else if cnt1 == 0 {
			num1 = v
			cnt1++
		} else if cnt2 == 0 {
			num2 = v
			cnt2++
		} else {
			cnt1--
			cnt2--
		}
	}

	cnt1, cnt2 = 0, 0
	for _, v := range nums {
		if num1 == v {
			cnt1++
		} else if num2 == v {
			cnt2++
		}
	}

	length := len(nums) / 3
	res := make([]int, 0)
	if cnt1 > 0 && cnt1 > length {
		res = append(res, num1)
	}
	if cnt2 > 0 && cnt2 > length {
		res = append(res, num2)
	}

	return res
}