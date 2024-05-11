package main

func romanToInt(s string) int {
	getMath := func(c byte) int {
		switch c {
		case 'I':
			return 1
		case 'V':
			return 5
		case 'X':
			return 10
		case 'L':
			return 50
		case 'C':
			return 100
		case 'D':
			return 500
		case 'M':
			return 1000
		default:
			return 0
		}
	}

	ans := 0
	for i := 0; i < len(s); i++ {
		if i < len(s)-1 && getMath(s[i]) < getMath(s[i+1]) {
			ans -= getMath(s[i])
		} else {
			ans += getMath(s[i])
		}
	}

	return ans
}
