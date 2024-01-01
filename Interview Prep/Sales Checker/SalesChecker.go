package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func solution(M, R, D int) string {
	initialSales := min(M, D)
	remainingDays := D - initialSales
	additionalSales := remainingDays
	maxSales := initialSales + additionalSales
	if maxSales >= R {
		return "YES"
	}
	return "NO"
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	fmt.Print("Enter the number of test cases: ")
	tcStr, _ := reader.ReadString('\n')
	tc, _ := strconv.Atoi(strings.TrimSpace(tcStr))
	for t := 0; t < tc; t++ {
		line, _ := reader.ReadString('\n')
		parts := strings.Fields(line)
		M, _ := strconv.Atoi(parts[0])
		R, _ := strconv.Atoi(parts[1])
		D, _ := strconv.Atoi(parts[2])
		result := solution(M, R, D)
		fmt.Println(result)
	}
}
