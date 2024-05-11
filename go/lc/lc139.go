package main

func wordBreak(s string, wordDict []string) bool {
	check := func(str string) bool {
		for _, v := range wordDict {
			if v == str {
				return true
			}
		}
		return false
	}

	dp := make([]bool, len(s)+1)
	dp[0] = true
	for i := 1; i <= len(s); i++ {
		for j := 0; j < i; j++ {
			dp[i] = dp[i] || (dp[j] && check(s[j:i]))
		}
	}

	return dp[len(s)]
}
