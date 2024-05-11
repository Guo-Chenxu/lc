package main

func canPlaceFlowers(flowerbed []int, n int) bool {
	for i := 0; i < len(flowerbed) && n > 0; i++ {
		if flowerbed[i] != 0 {
			continue
		}
		if i > 0 && flowerbed[i-1] != 0 {
			continue
		}
		if i < len(flowerbed)-1 && flowerbed[i+1] != 0 {
			continue
		}
		flowerbed[i] = 1
		n--
	}

	return n <= 0
}
