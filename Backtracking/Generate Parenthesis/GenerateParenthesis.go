package main

import (
	"fmt"
)

func generateParenthesis(n int) []string {
	var res []string
	recurse(&res, 0, 0, "", n)
	return res
}

func recurse(res *[]string, left, right int, current string, n int) {
	if len(current) == n*2 {
		*res = append(*res, current)
		return
	}

	if left < n {
		recurse(res, left+1, right, current+"(", n)
	}

	if right < left {
		recurse(res, left, right+1, current+")", n)
	}
}

func main() {
	var t int
	fmt.Scan(&t)
	for i := 0; i < t; i++ {
		var n int
		fmt.Scan(&n)
		result := generateParenthesis(n)
		for _, s := range result {
			fmt.Print(s + " ")
		}
		fmt.Println()
	}
}
