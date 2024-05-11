package main

import (
	"fmt"
	"strconv"
)

func sampleStats(count []int) []float64 {
	minimum := 0x7fffffff
	maximum := 0
	sum := 0
	cnt := 0
	mode := 0
	maxCnt := 0
	val := make([][]int, 0)
	for i, v := range count {
		if v != 0 {
			if i < minimum {
				minimum = i
			}
			if i > maximum {
				maximum = i
			}
			if v > maxCnt {
				maxCnt = v
				mode = i
			}
			sum += i * v
			cnt += v
			val = append(val, []int{i, v})
		}
	}
	mean := float64(sum) / float64(cnt)
	median := getMedian(val, cnt)
	value1, _ := strconv.ParseFloat(fmt.Sprintf("%.5f", float64(minimum)), 64)
	value2, _ := strconv.ParseFloat(fmt.Sprintf("%.5f", float64(maximum)), 64)
	value3, _ := strconv.ParseFloat(fmt.Sprintf("%.5f", float64(mean)), 64)
	value4, _ := strconv.ParseFloat(fmt.Sprintf("%.5f", median), 64)
	value5, _ := strconv.ParseFloat(fmt.Sprintf("%.5f", float64(mode)), 64)
	return []float64{value1, value2, value3, value4, value5}
}

func getMedian(val [][]int, cnt int) float64 {
	x := (cnt >> 1)
	x1 := -1
	x2 := -1
	for i, v := range val {
		x -= v[1]
		if x < 0 {
			x1 = v[0]
			if x2 == -1 {
				x2 = v[0]
			}
			break
		} else if x == 0 {
			x1 = v[0]
			x2 = val[i+1][0]
			break
		}
	}
	if (cnt & 1) == 0 {
		return float64((x1 + x2)) / 2.0
	} else {
		return float64(x2)
	}
}
