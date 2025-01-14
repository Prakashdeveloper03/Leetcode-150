package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

func maxProductOfFour(arr []int) int64 {
	if len(arr) < 4 {
		return -1
	}
	sort.Ints(arr)
	maxProduct1 := int64(arr[len(arr)-1]) * int64(arr[len(arr)-2]) * int64(arr[len(arr)-3]) * int64(arr[len(arr)-4])
	maxProduct2 := int64(arr[0]) * int64(arr[1]) * int64(arr[len(arr)-1]) * int64(arr[len(arr)-2])
	if maxProduct1 > maxProduct2 {
		return maxProduct1
	}
	return maxProduct2
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
		fmt.Println(maxProductOfFour(arr))
	}
}
