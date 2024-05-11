package main

func lemonadeChange(bills []int) bool {
	if bills[0] != 5 {
		return false
	}

	cnt := make([]int, 21)
	for _, v := range bills {
		if v == 5 {
			cnt[5]++
		} else if v == 10 {
			cnt[5]--
			cnt[10]++
		} else {
			if cnt[10] > 0 {
				cnt[10]--
				cnt[5]--
			} else {
				cnt[5] -= 3
			}
			cnt[20]++
		}
		if cnt[5] < 0 {
			return false
		}
	}

	return true
}
