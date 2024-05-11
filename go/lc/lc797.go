package main

func allPathsSourceTarget(graph [][]int) [][]int {
	ans := make([][]int, 0)

	var dfs func(cur int, path []int)
	dfs = func(cur int, path []int) {
		if cur == len(graph)-1 {
			t := make([]int, len(path))
			copy(t, path)
			ans = append(ans, t)
		}

		for i := 0; i < len(graph[cur]); i++ {
			path = append(path, graph[cur][i])
			dfs(graph[cur][i], path)
			path = path[:len(path)-1]
		}
	}

	dfs(0, []int{0})
	return ans
}
