package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func findLastNonZeroIndex(arr []int) int {
	for i := len(arr) - 1; i >= 0; i-- {
		if arr[i] != 0 {
			return i
		}
	}
	return -1
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	tcStr, _ := reader.ReadString('\n')
	tc, _ := strconv.Atoi(strings.TrimSpace(tcStr))
	for t := 0; t < tc; t++ {
		nStr, _ := reader.ReadString('\n')
		n, _ := strconv.Atoi(strings.TrimSpace(nStr))
		arrStr, _ := reader.ReadString('\n')
		arrParts := strings.Fields(arrStr)
		arr := make([]int, n)
		for i := 0; i < n; i++ {
			arr[i], _ = strconv.Atoi(arrParts[i])
		}
		index := findLastNonZeroIndex(arr)
		fmt.Println(index)
	}
}
