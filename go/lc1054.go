package main

func rearrangeBarcodes(barcodes []int) []int {
	n := len(barcodes)
	j := 0
	for i := 0; i < n-1; i++ {
		if barcodes[i] != barcodes[i+1] {
			continue
		}
		j = i + 2
		for j < n && barcodes[i] == barcodes[j] {
			j++
		}
		if j >= n {
			break
		}
		barcodes[j], barcodes[i+1] = barcodes[i+1], barcodes[j]
	}
	if j < n {
		return barcodes
	}
	for i := n - 1; i > 0; i-- {
		if barcodes[i] != barcodes[i-1] {
			continue
		}
		j = i - 2
		for j < n && barcodes[i] == barcodes[j] {
			j--
		}
		if j < 0 {
			break
		}
		barcodes[j], barcodes[i-1] = barcodes[i-1], barcodes[j]
	}
	return barcodes
}
