package main

func initSet(n int) []int {
	father := make([]int, n)
	for i := range father {
		father[i] = i
	}
	return father
}

func find(n int, father []int) int {
	if father[n] == n {
		return n
	}
	father[n] = find(father[n], father)
	return father[n]
}

func isSame(u, v int, father []int) bool {
	u, v = find(u, father), find(v, father)
	return u == v
}

func join(u, v int, father []int) {
	u, v = find(u, father), find(v, father)
	if u == v {
		return
	}
	father[u] = v
}

func findRedundantConnection(edges [][]int) []int {
	father := initSet(len(edges) + 1)
	ans := make([]int, 0)

	for _, e := range edges {
		if isSame(e[0], e[1], father) {
			ans = []int{e[0], e[1]}
		} else {
			join(e[1], e[0], father)
		}
	}

	return ans
}
