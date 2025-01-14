package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func twoSum(nums []int, target int) []int {
	mapIndices := make(map[int]int)
	for i, num := range nums {
		complement := target - num
		if idx, exists := mapIndices[complement]; exists {
			return []int{idx, i}
		}
		mapIndices[num] = i
	}
	return nil
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	tcStr, _ := reader.ReadString('\n')
	tc := toInt(strings.TrimSpace(tcStr))
	for t := 0; t < tc; t++ {
		numsStr, _ := reader.ReadString('\n')
		nums := toIntArray(strings.TrimSpace(numsStr))
		targetStr, _ := reader.ReadString('\n')
		target := toInt(strings.TrimSpace(targetStr))
		result := twoSum(nums, target)
		if result != nil {
			fmt.Printf("%d %d\n", result[0], result[1])
		} else {
			fmt.Println("No solution found")
		}
	}
}

func toInt(s string) int {
	num, _ := strconv.Atoi(s)
	return num
}

func toIntArray(s string) []int {
	strs := strings.Fields(s)
	nums := make([]int, len(strs))
	for i, str := range strs {
		nums[i] = toInt(str)
	}
	return nums
}
