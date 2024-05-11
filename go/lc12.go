package main

func intToRoman(num int) string {
	value := []struct {
		val    int
		symbol string
	}{
		{1000, "M"},
		{900, "CM"},
		{500, "D"},
		{400, "CD"},
		{100, "C"},
		{90, "XC"},
		{50, "L"},
		{40, "XL"},
		{10, "X"},
		{9, "IX"},
		{5, "V"},
		{4, "IV"},
		{1, "I"},
	}

	ans := ""
	for _, v := range value {
		for num >= v.val {
			num -= v.val
			ans = ans + v.symbol
		}
		if num == 0 {
			break
		}
	}

	return ans
}
