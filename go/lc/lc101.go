package main

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	var cmp func(l, r *TreeNode) bool
	cmp = func(l, r *TreeNode) bool {
		if l == nil && r == nil {
			return true
		} else if l != nil && r != nil {
			if l.Val != r.Val {
				return false
			}
			return cmp(l.Left, r.Right) && cmp(l.Right, r.Left)
		} else {
			return false
		}
	}
	return cmp(root.Left, root.Right)
}
