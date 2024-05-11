package main

func findBottomLeftValue(root *TreeNode) int {
	cur := make([]*TreeNode, 0)
	cur = append(cur, root)
	res := root.Val
	for len(cur) != 0 {
		next := make([]*TreeNode, 0)
		res = cur[0].Val
		for _, v := range cur {
			if v.Left != nil {
				next = append(next, v.Left)
			}
			if v.Right != nil {
				next = append(next, v.Right)
			}
		}
		cur = next
	}
	return res
}
