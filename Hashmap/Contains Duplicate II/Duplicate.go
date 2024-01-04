package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func containsNearbyDuplicate(nums []int, k int) bool {
	seen := make(map[int]int)
	for i, val := range nums {
		if prevIndex, exists := seen[val]; exists && i-prevIndex <= k {
			return true
		}
		seen[val] = i
	}
	return false
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	tcStr, _ := reader.ReadString('\n')
	tc, _ := strconv.Atoi(strings.TrimSpace(tcStr))
	for t := 0; t < tc; t++ {
		nStr, _ := reader.ReadString('\n')
		n, _ := strconv.Atoi(strings.TrimSpace(nStr))
		numsStr, _ := reader.ReadString('\n')
		numsSlice := strings.Fields(numsStr)
		nums := make([]int, n)
		for i := 0; i < n; i++ {
			nums[i], _ = strconv.Atoi(numsSlice[i])
		}
		targetStr, _ := reader.ReadString('\n')
		target, _ := strconv.Atoi(strings.TrimSpace(targetStr))
		result := containsNearbyDuplicate(nums, target)
		fmt.Println(result)
	}
}
