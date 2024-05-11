package main

func canFinish(numCourses int, prerequisites [][]int) bool {
	degree, queue := make([]int, numCourses), make([]int, 0)
	pres := make([][]int, numCourses)
	ok := make([]bool, numCourses)
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
			ok[i] = true
		}
	}

	for len(queue) > 0 {
		cur := queue[0]
		queue = queue[1:]
		for _, v := range pres[cur] {
			degree[v]--
			if degree[v] == 0 {
				ok[v] = true
				queue = append(queue, v)
			}
		}
	}

	for _, v := range ok {
		if v == false {
			return false
		}
	}

	return true
}
