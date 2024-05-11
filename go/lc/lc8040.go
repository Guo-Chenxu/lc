package main

func minimumOperations(num string) int {
	length := len(num)
	if length == 1 {
		if num != "0" {
			return 1
		} else {
			return 0
		}
	}

	nums := []rune(num)
	if nums[length-1] == '0' {
		if nums[length-2] == '0' || nums[length-2] == '5' {
			return 0
		}
	} else if nums[length-1] == '5' {
		if nums[length-2] == '2' || nums[length-2] == '7' {
			return 0
		}
	}

	min := func(a, b int) int {
		if a < b {
			return a
		}
		return b
	}

	getRes := func(res, i int, p []int) int {
		for _, idx := range p {
			if idx >= i {
				break
			}
			res = min(res, i-idx-1+length-i-1)
		}
		return res
	}

	res := 0x7fffffff
	nMap := make(map[rune][]int, 10)
	for i, v := range nums {
		if v == '0' || v == '2' || v == '5' || v == '7' {
			if nMap[v] == nil {
				nMap[v] = make([]int, 0)
			}
			nMap[v] = append(nMap[v], i)
		}
		if v == '0' {
			res = getRes(res, i, nMap['0'])
			res = getRes(res, i, nMap['5'])
		} else if v == '5' {
			res = getRes(res, i, nMap['2'])
			res = getRes(res, i, nMap['7'])
		}
	}

	if res == 0x7fffffff{
		if len(nMap['0']) == 0{
			res = length
		}else{
			res = length - 1
		}
	}
	return res
}
