package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(preorder []int, inorder []int) *TreeNode {
	idxMap := make(map[int]int, 0)
	for i, v := range inorder {
		idxMap[v] = i
	}

	var builder func(l, r int) *TreeNode
	builder = func(l, r int) *TreeNode {
		if l >= r || len(preorder) <= 0 {
			return nil
		}

		val := preorder[0]
		node := &TreeNode{Val: val}
		preorder = preorder[1:]

		node.Left = builder(l, idxMap[val])
		node.Right = builder(idxMap[val]+1, r)
		return node
	}

	return builder(0, len(preorder))
}
