package main

func canVisitAllRooms(rooms [][]int) bool {
	vis, sum := make([]bool, len(rooms)), 1
	vis[0] = true

	var dfs func(cur int) bool
	dfs = func(cur int) bool {
		for _, v := range rooms[cur] {
			if !vis[v] {
				vis[v] = true
				sum++
				dfs(v)
			}
		}

		return sum == len(rooms)
	}

	return dfs(0)
}
