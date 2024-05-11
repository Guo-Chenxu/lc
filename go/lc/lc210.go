package main

func findOrder(numCourses int, prerequisites [][]int) []int {
	degree, queue := make([]int, numCourses), make([]int, 0)
	pres := make([][]int, numCourses)
	ans := make([]int, 0)
	for i := range pres {
		pres[i] = make([]int, 0)
	}

	for _, v := range prerequisites {
		degree[v[0]]++
		pres[v[1]] = append(pres[v[1]], v[0])
	}
	for i := range degree {
		if degree[i] == 0 {
			queue = append(queue, i)
			ans = append(ans, i)
		}
	}

	for len(queue) > 0 {
		cur := queue[0]
		queue = queue[1:]
		for _, v := range pres[cur] {
			degree[v]--
			if degree[v] == 0 {
				ans = append(ans, v)
				queue = append(queue, v)
			}
		}
	}

	if len(ans) != numCourses {
		return []int{}
	}
	return ans
}
