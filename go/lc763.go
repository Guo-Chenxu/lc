package main

// ! these are shit codes
// import "sort"
// func partitionLabels(s string) []int {
// 	idxs := make(map[rune][]int, 27)
// 	for i, v := range s {
// 		if _, ok := idxs[v]; !ok {
// 			idxs[v] = make([]int, 0)
// 		}
// 		idxs[v] = append(idxs[v], i)
// 	}

// 	pos := make([][]int, 0)
// 	for _, v := range idxs {
// 		l, r := func(is []int) (int, int) {
// 			a, b := is[0], is[0]
// 			for _, ii := range is {
// 				if ii < a {
// 					a = ii
// 				} else if ii > b {
// 					b = ii
// 				}
// 			}
// 			return a, b
// 		}(v)
// 		pos = append(pos, []int{l, r})
// 	}

// 	sort.Slice(pos, func(i, j int) bool {
// 		return pos[i][0] < pos[j][0]
// 	})

// 	ans, l, r := make([]int, 0), pos[0][0], pos[0][1]
// 	for _, p := range pos {
// 		if p[0] <= r {
// 			if p[1] > r {
// 				r = p[1]
// 			}
// 			if p[0] < l {
// 				l = p[0]
// 			}
// 		} else {
// 			ans = append(ans, r-l+1)
// 			l, r = p[0], p[1]
// 		}
// 	}
// 	ans = append(ans, r-l+1)

// 	return ans
// }

func partitionLabels(s string) []int {
	pos := make([]int, 27)
	for i, v := range s {
		pos[v-'a'] = i
	}

	ans, l, r := make([]int, 0), 0, 0
	for i, v := range s {
		if pos[v-'a'] > r {
			r = pos[v-'a']
		}
		if i == r {
			ans = append(ans, r-l+1)
			l = r + 1
		}
	}

	return ans
}
