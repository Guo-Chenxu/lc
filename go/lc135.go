package main

func candy(ratings []int) int {
	l, r := make([]int, len(ratings)), make([]int, len(ratings))
	l[0], r[len(ratings)-1] = 1, 1
	ans := 0

	for i := 1; i < len(l); i++ {
		if ratings[i] > ratings[i-1] {
			l[i] = l[i-1] + 1
		} else {
			l[i] = 1
		}
	}

	for i := len(r) - 2; i >= 0; i-- {
		if ratings[i] > ratings[i+1] {
			r[i] = r[i+1] + 1
		} else {
			r[i] = 1
		}
	}

	for i := range ratings {
		ans += func(a, b int) int {
			if a > b {
				return a
			}
			return b
		}(l[i], r[i])
	}

	return ans
}
