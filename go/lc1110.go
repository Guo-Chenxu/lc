package main

func delNodes(root *TreeNode, to_delete []int) []*TreeNode {
	res := make([]*TreeNode, 0)
	set := make(map[int]int, len(to_delete))
	for _, x := range to_delete {
		set[x] = 1
	}
	var dfs func(*TreeNode) *TreeNode
	dfs = func(node *TreeNode) *TreeNode {
		if node == nil {
			return nil
		}
		node.Left = dfs(node.Left)
		node.Right = dfs(node.Right)
		if _, ok := set[node.Val]; !ok {
			return node
		}
		if node.Left != nil {
			res = append(res, node.Left)
		}
		if node.Right != nil {
			res = append(res, node.Right)
		}
		return nil
	}
	if dfs(root) != nil {
		res = append(res, root)
	}
	return res
}
