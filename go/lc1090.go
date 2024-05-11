package main

import (
	"math"
	"sort"
)

func largestValsFromLabels(values []int, labels []int, numWanted int, useLimit int) int {
	bucket := make(map[int][]int, 0)
	n := len(values)
	for i := 0; i < n; i++ {
		bucket[labels[i]] = append(bucket[labels[i]], values[i])
	}
	cnt := make([]int, 0)
	for _, b := range bucket {
		sort.Sort(sort.Reverse(sort.IntSlice(b)))
		len := int(math.Min(float64(useLimit), float64(len(b))))
		for i := 0; i < len; i++ {
			cnt = append(cnt, b[i])
		}
	}
	sort.Sort(sort.Reverse(sort.IntSlice(cnt)))
	sum := 0
	len := int(math.Min(float64(numWanted), float64(len(cnt))))
	for i := 0; i < len; i++ {
		sum += cnt[i]
	}
	return sum
}

func largestValsFromLabels01(values []int, labels []int, numWanted int, useLimit int) int {
	n := len(values)
	idx := make([]int, n)
	for i := 0; i < n; i++ {
		idx[i] = i
	}
	sort.Slice(idx, func(i, j int) bool {
		return values[idx[i]] > values[idx[j]]
	})

	sum := 0
	choose := 0
	cnt := make(map[int]int, n)
	for _, i := range idx {
		label := labels[i]
		if cnt[label] >= useLimit {
			continue
		}
		cnt[label]++
		choose++
		sum += values[i]
		if choose >= numWanted {
			break
		}
	}

	return sum
}
