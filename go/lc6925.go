package main

func finalString(s string) string {
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

	sb, n, cnt := []byte(s), len(s), 0
	for i, j := 0, 0; j < len(s); {
		if sb[j] == 'i' {
			sb = reverse(0, i, sb)
			j++
			cnt++
		} else {
			sb[i] = sb[j]
			i++
			j++
		}
	}

	return string(sb[0 : n-cnt])
}
