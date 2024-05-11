package main

func kItemsWithMaximumSum(numOnes int, numZeros int, numNegOnes int, k int) int {
	if numOnes >= k {
		return k
	} else if numOnes+numZeros >= k {
		return numOnes
	}
	return numOnes - (k - numOnes - numZeros)
}
