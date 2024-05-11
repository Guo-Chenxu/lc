package main

// // 双向bfs, 但是麻烦了, 双倍的时间复杂度
// func ladderLength(beginWord string, endWord string, wordList []string) int {
// 	ok := false
// 	for _, s := range wordList {
// 		if s == endWord {
// 			ok = true
// 		}
// 	}
// 	if !ok {
// 		return 0
// 	}

// 	type node struct {
// 		word string
// 		step int
// 	}

// 	isOneCharDiff := func(str1, str2 string) bool {
// 		if len(str1) != len(str2) {
// 			return false
// 		}

// 		diffCount := 0
// 		for i := 0; i < len(str1); i++ {
// 			if str1[i] != str2[i] {
// 				diffCount++
// 				if diffCount > 1 {
// 					return false
// 				}
// 			}
// 		}

// 		return diffCount == 1
// 	}

// 	bfs := func(word string) []int {
// 		queue := make([]*node, 0)
// 		queue = append(queue, &node{word: word, step: 0})

// 		cnt, vis := make([]int, len(wordList)), make([]bool, len(wordList))
// 		for i := range cnt {
// 			cnt[i] = -1
// 		}
// 		for len(queue) > 0 {
// 			cur := queue[0]
// 			queue = queue[1:]
// 			for i, s := range wordList {
// 				if !vis[i] {
// 					if s == cur.word {
// 						queue = append(queue, &node{word: s, step: cur.step})
// 						cnt[i] = cur.step
// 						vis[i] = true
// 					} else if isOneCharDiff(s, cur.word) {
// 						queue = append(queue, &node{word: s, step: cur.step + 1})
// 						cnt[i] = cur.step + 1
// 						vis[i] = true
// 					}
// 				}
// 			}
// 		}

// 		return cnt
// 	}

// 	be, eb := bfs(beginWord), bfs(endWord)
// 	ans := 0x7fffffff
// 	for i := range be {
// 		if be[i] != -1 && eb[i] != -1 && be[i]+eb[i] < ans {
// 			ans = be[i] + eb[i]
// 		}
// 	}

// 	if ans == 0x7fffffff {
// 		return 0
// 	}
// 	return ans + 1
// }

// 单向
func ladderLength(beginWord string, endWord string, wordList []string) int {
	idx := -1
	for i, s := range wordList {
		if s == endWord {
			idx = i
			break
		}
	}
	if idx == -1 {
		return 0
	}

	type node struct {
		word string
		step int
	}

	isOneCharDiff := func(str1, str2 string) bool {
		if len(str1) != len(str2) {
			return false
		}

		diffCount := 0
		for i := 0; i < len(str1); i++ {
			if str1[i] != str2[i] {
				diffCount++
				if diffCount > 1 {
					return false
				}
			}
		}

		return diffCount == 1
	}

	bfs := func(word string) []int {
		queue := make([]*node, 0)
		queue = append(queue, &node{word: word, step: 0})

		cnt, vis := make([]int, len(wordList)), make([]bool, len(wordList))
		for i := range cnt {
			cnt[i] = -1
		}
		for len(queue) > 0 {
			cur := queue[0]
			queue = queue[1:]
			for i, s := range wordList {
				if !vis[i] {
					if s == cur.word {
						queue = append(queue, &node{word: s, step: cur.step})
						cnt[i] = cur.step
						vis[i] = true
					} else if isOneCharDiff(s, cur.word) {
						queue = append(queue, &node{word: s, step: cur.step + 1})
						cnt[i] = cur.step + 1
						vis[i] = true
					}
				}
			}
		}

		return cnt
	}

	be := bfs(beginWord)
	if be[idx] == -1 {
		return 0
	}
	return be[idx] + 1
}
