package main

type Node struct {
	Val      int
	Children []*Node
}

func maxDepth(root *Node) int {
	// 此部分由 codegeek 生成
	// if root == nil {
	// 	return 0
	// }
	// max := func(a, b int) int {
	// 	if a > b {
	// 		return a
	// 	}
	// 	return b
	// }
	// depth := 0
	// for _, child := range root.Children {
	// 	depth = max(depth, maxDepth(child))
	// }
	// return depth + 1

	if root == nil {

		return 0
	}
	cur, depth := make([]Node, 0), 0
	cur = append(cur, *root)
	for len(cur) > 0 {
		next := make([]Node, 0)
		for _, v := range cur {
			for _, c := range v.Children {
				if c != nil {
					next = append(next, *c)
				}
			}
		}
		cur = next
		depth++
	}
	return depth
}
