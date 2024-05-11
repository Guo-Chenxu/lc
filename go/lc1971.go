package main

func initSet(n int) []int {
	father := make([]int, n)
	for i := range father {
		father[i] = i
	}
	return father
}

func find(u int, father []int) int {
	if u == father[u] {
		return u
	}
	father[u] = find(father[u], father)
	return father[u]
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

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func validPath(n int, edges [][]int, source int, destination int) bool {
	father := initSet(n)

	for _, e := range edges {
		join(max(e[0], e[1]), min(e[0], e[1]), father)
	}

	return isSame(source, destination, father)
}
