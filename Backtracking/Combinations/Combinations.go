package main

import (
	"fmt"
)

func combine(n int, k int) [][]int {
	var res [][]int
	var comb []int
	backtrack(1, &comb, &res, n, k)
	return res
}

func backtrack(start int, comb *[]int, res *[][]int, n int, k int) {
	if len(*comb) == k {
		copyList := make([]int, len(*comb))
		copy(copyList, *comb)
		*res = append(*res, copyList)
		return
	}
	for num := start; num <= n; num++ {
		*comb = append(*comb, num)
		backtrack(num+1, comb, res, n, k)
		*comb = (*comb)[:len(*comb)-1]
	}
}

func main() {
	var t int
	fmt.Scan(&t)
	for i := 0; i < t; i++ {
		var n, k int
		fmt.Scan(&n, &k)
		result := combine(n, k)
		for _, nextList := range result {
			for _, x := range nextList {
				fmt.Print(x, " ")
			}
			fmt.Println()
		}
	}
}
