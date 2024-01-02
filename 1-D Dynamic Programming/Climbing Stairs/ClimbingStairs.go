package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func climbStairs(n int) int {
	if n < 0 {
		return 0
	}
	if n == 0 || n == 1 {
		return 1
	}
	if n == 2 {
		return 2
	}
	n1, n2, current := 1, 2, 0
	for i := 2; i < n; i++ {
		current = n1 + n2
		n1 = n2
		n2 = current
	}
	return current
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	tcStr, _ := reader.ReadString('\n')
	tc, _ := strconv.Atoi(strings.TrimSpace(tcStr))
	for t := 0; t < tc; t++ {
		nStr, _ := reader.ReadString('\n')
		n, _ := strconv.Atoi(strings.TrimSpace(nStr))
		fmt.Println(climbStairs(n))
	}
}
