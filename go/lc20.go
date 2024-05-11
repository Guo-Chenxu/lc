package main

func isValid(s string) bool {
	brackets := make([]rune, 0)
	if s[0] == ')' || s[0] == ']' || s[0] == '}' {
		return false
	}

	for _, v := range s {
		n := len(brackets)
		if v == ')' || v == ']' || v == '}' {
			if n == 0 {
				return false
			}
			if v == ')' && brackets[n-1] == '(' {
				brackets = brackets[:n-1]
			} else if v == ']' && brackets[n-1] == '[' {
				brackets = brackets[:n-1]
			} else if v == '}' && brackets[n-1] == '{' {
				brackets = brackets[:n-1]
			} else {
				return false
			}
		} else {
			brackets = append(brackets, v)
		}
	}
	return len(brackets) == 0
}
