package main

func addNegabinary(arr1 []int, arr2 []int) (ans []int) {
	len1, len2 := len(arr1), len(arr2)
	c := 0
	i, j := len1-1, len2-1
	for i >= 0 || j >= 0 || c != 0 {
		x := c
		if i >= 0 {
			x += arr1[i]
		}
		if j >= 0 {
			x += arr2[j]
		}
		if x >= 2 {
			ans = append(ans, x-2)
			c = -1
		} else if x >= 0 {
			ans = append(ans, x)
			c = 0
		} else {
			ans = append(ans, 1)
			c = 1
		}
		i--
		j--
	}
	for i = len(ans) - 1; i > 0 && ans[i] == 0; i-- {
		ans = ans[:i]
	}
	for i, j = 0, len(ans)-1; i <= j; {
		ans[i], ans[j] = ans[j], ans[i]
		i++
		j--
	}
	return ans
}
