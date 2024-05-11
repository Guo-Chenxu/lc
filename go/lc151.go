package main

func reverseWords(s string) string {
	length := len(s)
	str := make([]byte, length)
	j := 0

	// 先删除所有空格
	for i := 0; i < length; i++ {
		if s[i] != ' ' {
			str[j] = s[i]
			j++
		} else {
			if i > 0 && s[i-1] != ' ' {
				str[j] = s[i]
				j++
			}
		}
	}
	if str[j-1] == ' ' {
		j--
	}
	str = str[:j]

	// 反转函数
	reverse := func(l, r int, str []byte) []byte {
		for l < r {
			t := str[l]
			str[l] = str[r]
			str[r] = t
			l++
			r--
		}
		return str
	}

	// hello world --> dlrow olleh --> world hello

	// 整个句子反转
	str = reverse(0, j-1, str)

	// 单个单词反转
	for i := 0; i < j; i++ {
		k := i
		for ; k < j && str[k] != ' '; k++ {

		}
		str = reverse(i, k-1, str)
		i = k
	}

	return string(str)
}
