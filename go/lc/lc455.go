package main

import "sort"

func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)
	ans := 0
	is, ig := 0, 0
	for is < len(s) && ig < len(g) {
		if s[is] >= g[ig]{
			ans++
			is++
			ig++
		}else{
			is++
		}
	}
	return ans
}
