package main

func numTilePossibilities(tiles string) int {
	count := make(map[rune]int)
	for _, c := range tiles {
		count[c]++
	}
	return dfs1079(count, len(tiles)) - 1
}

func dfs1079(count map[rune]int, n int) int {
	if n == 0 {
		return 1
	}
	res := 1
	for k := range count {
		if count[k] > 0 {
			count[k]--
			res += dfs1079(count, n-1)
			count[k]++
		}
	}
	return res
}
