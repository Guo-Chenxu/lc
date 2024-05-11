package main

import "sort"

func reconstructQueue(people [][]int) [][]int {
	sort.Slice(people, func(i, j int) bool {
		if people[i][0] != people[j][0]{
			return people[i][0] > people[j][0]
		}
		return people[i][1] < people[j][1]
	})

	type ListNode struct {
		p    any
		next *ListNode
	}

	head := &ListNode{}
	for _, p := range people {
		h, pos := head, p[1]
		for h.next != nil && pos != 0 {
			pos--
			h = h.next
		}
		h.next = &ListNode{
			p:    p,
			next: h.next,
		}
	}

	ans := make([][]int, 0)
	for head.next != nil {
		ans = append(ans, head.next.p.([]int))
		head = head.next
	}
	return ans
}
