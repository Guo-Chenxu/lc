package main

import (
	"math"
	"strconv"
)

func maxEqualRowsAfterFlips(matrix [][]int) int {
	n := len(matrix[0])
	mmap := make(map[string]int, 0)
	for _, m := range matrix {
		x := m[0]
		cnt := 1
		s := ""
		for i := 0; i < n; i++ {
			if m[i] != x {
				s = s + strconv.Itoa(cnt) + "-"
				cnt = 1
				x = m[i]
			} else {
				cnt++
			}
		}
		s = s + strconv.Itoa(cnt)
		mmap[s] = mmap[s] + 1
	}
	res := 1
	for _, val := range mmap {
		res = int(math.Max(float64(res), float64(val)))
	}
	return res
}

type Node struct {
	left, right *Node
	val         int
}

func maxEqualRowsAfterFlips01(matrix [][]int) int {
	n := len(matrix[0])
	root := &Node{nil, nil, 0}
	res := 1
	for _, m := range matrix {
		x := m[0]
		now := root
		for i := 1; i < n; i++ {
			if m[i] == x {
				if now.left == nil {
					now.left = &Node{nil, nil, 0}
				}
				now = now.left
			} else {
				if now.right == nil {
					now.right = &Node{nil, nil, 0}
				}
				now = now.right
			}
		}
		now.val++
		if now.val > res {
			res = now.val
		}
	}
	return res
}
