package main



func countNodes(root *TreeNode) int {
	if root == nil{
		return 0
	}
	l, r := 0, 0
	lNode, rNode := root.Left, root.Right
	for lNode != nil{
		l++
		lNode = lNode.Left
	}
	for rNode != nil{
		r++
		rNode = rNode.Right
	}
	if l == r{
		return (2 << l) - 1
	}
	return countNodes(root.Left) + countNodes(root.Right) + 1
}