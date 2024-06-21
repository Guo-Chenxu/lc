package main

func temperatureTrend(temperatureA []int, temperatureB []int) int {
	cmp := func(a, b int) int {
		if a > b {
			return 1
		} else if a < b {
			return -1
		} else {
			return 0
		}
	}

	max := func(a, b int) int {
		if a >= b {
			return a
		} else {
			return b
		}
	}

	res, tmp := 0, 0
	for i := 1; i < len(temperatureA); i++ {
		if cmp(temperatureA[i], temperatureA[i-1])-cmp(temperatureB[i], temperatureB[i-1]) == 0 {
			tmp++
		} else {
			res = max(res, tmp)
			tmp = 0
		}
	}

	return max(res, tmp)
}
