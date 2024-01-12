package main

import (
	"fmt"
)

func letterCombinations(digits string) []string {
	var res []string
	if len(digits) == 0 {
		return res
	}
	digitToLetters := map[rune]string{
		'2': "abc", '3': "def", '4': "ghi", '5': "jkl", '6': "mno",
		'7': "pqrs", '8': "tuv", '9': "wxyz",
	}
	backtrack(digits, 0, "", &res, digitToLetters)
	return res
}

func backtrack(digits string, idx int, comb string, res *[]string, digitToLetters map[rune]string) {
	if idx == len(digits) {
		*res = append(*res, comb)
		return
	}

	letters := digitToLetters[rune(digits[idx])]
	for _, letter := range letters {
		backtrack(digits, idx+1, comb+string(letter), res, digitToLetters)
	}
}

func main() {
	var t int
	fmt.Scan(&t)
	for i := 0; i < t; i++ {
		var digits string
		fmt.Scan(&digits)
		result := letterCombinations(digits)
		for _, s := range result {
			fmt.Print(s + " ")
		}
		fmt.Println()
	}
}
