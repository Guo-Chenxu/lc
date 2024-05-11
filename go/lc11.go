package main

func maxArea(height []int) int {
	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	area := 0
	for i, j := 0, len(height)-1; i < j; {
		if height[i] < height[j] {
			area = max(area, height[i]*(j-i))
			i++
		} else {
			area = max(area, height[j]*(j-i))
			j--
		}
	}
	return area
}

func maxArea1(height []int) int {
	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}
	min := func(a, b int) int {
		if a < b {
			return a
		}
		return b
	}

	area := 0
	for i, j := 0, len(height)-1; i < j; {
		area = max(area, (j-i)*min(height[i], height[j]))
		for i < j && height[i] < height[j] {
			i++
		}
		area = max(area, (j-i)*min(height[i], height[j]))
		for i < j && height[i] >= height[j] {
			j--
			area = max(area, (j-i)*min(height[i], height[j]))
		}
	}
	return area
}
