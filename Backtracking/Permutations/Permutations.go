package main

import (
	"fmt"
)

func permute(nums []int) [][]int {
	var result [][]int
	backtrack(&result, []int{}, nums)
	return result
}

func backtrack(result *[][]int, tempList []int, nums []int) {
	if len(tempList) == len(nums) {
		copyList := make([]int, len(tempList))
		copy(copyList, tempList)
		*result = append(*result, copyList)
		return
	}
	for i := 0; i < len(nums); i++ {
		if contains(tempList, nums[i]) {
			continue
		}
		tempList = append(tempList, nums[i])
		backtrack(result, tempList, nums)
		tempList = tempList[:len(tempList)-1]
	}
}

func contains(slice []int, num int) bool {
	for _, v := range slice {
		if v == num {
			return true
		}
	}
	return false
}

func main() {
	var t int
	fmt.Scan(&t)
	for i := 0; i < t; i++ {
		var n int
		fmt.Scan(&n)
		nums := make([]int, n)
		for j := 0; j < n; j++ {
			fmt.Scan(&nums[j])
		}
		result := permute(nums)
		for _, nextList := range result {
			for _, x := range nextList {
				fmt.Print(x, " ")
			}
			fmt.Println()
		}
	}
}
