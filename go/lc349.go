package main

func intersection(nums1 []int, nums2 []int) []int {
	cnt := [1001]int{}
	for _, v := range nums1 {
		cnt[v]++
	}
	res, dis := make(map[int]int, 0), make([]int, 0)
	for _, v := range nums2 {
		if cnt[v] != 0 {
			res[v]++
		}
	}
	for k := range res {
		dis = append(dis, k)
	}
	return dis
}
