package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func constructMaximumBinaryTree(nums []int) *TreeNode {
	var builder func(l, r int) *TreeNode
	builder = func(l, r int) *TreeNode {
		if l >= r {
			return nil
		}

		idx := l
		for i := l; i < r; i++ {
			if nums[i] > nums[idx] {
				idx = i
			}
		}

		node := &TreeNode{Val: nums[idx]}
		node.Left = builder(l, idx)
		node.Right = builder(idx+1, r)
		return node
	}

	return builder(0, len(nums))
}
