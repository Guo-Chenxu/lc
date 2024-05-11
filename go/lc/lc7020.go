package main

import (
	"strconv"
)

func countSymmetricIntegers(low int, high int) int {
	count := 0

	for i := 10; i <= high; i++ {
		num := strconv.Itoa(i)
		n := len(num)
		sum1 := 0
		sum2 := 0
		if n&1 == 0 {
			for j := 0; j < n/2; j++ {
				digit := int(num[j] - '0')
				sum1 += digit
			}
			for j := n / 2; j < n; j++ {
				digit := int(num[j] - '0')
				sum2 += digit
			}
			if sum1 == sum2 {
				count++
			}
		}
	}

	return count
}
