package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(inorder []int, postorder []int) *TreeNode {
	idxMap := make(map[int]int, 0)
	for i, v := range inorder {
		idxMap[v] = i
	}

	var builder func(l, r int) *TreeNode
	builder = func(l, r int) *TreeNode {
		length := len(postorder)
		if l >= r || length <= 0 {
			return nil
		}

		val := postorder[length-1]
		node := &TreeNode{Val: val}
		postorder = postorder[:length-1]

		node.Right = builder(idxMap[val]+1, r)
		node.Left = builder(l, idxMap[val])
		return node
	}

	return builder(0, len(inorder))
}
