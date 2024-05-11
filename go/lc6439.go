package main

import "strings"

func minLength(s string) int {
	for strings.Contains(s, "AB") || strings.Contains(s, "CD") {
		s = strings.Trim(s, "AB")
		s = strings.Trim(s, "CD")
	}
	return len(s)
}
