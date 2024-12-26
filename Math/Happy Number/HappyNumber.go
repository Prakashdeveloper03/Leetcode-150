package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func isHappy(n int) bool {
	visited := make(map[int]bool)
	for !visited[n] {
		visited[n] = true
		n = getNextNumber(n)
		if n == 1 {
			return true
		}
	}
	return false
}

func getNextNumber(n int) int {
	output := 0
	for n > 0 {
		digit := n % 10
		output += digit * digit
		n /= 10
	}
	return output
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	tcStr, _ := reader.ReadString('\n')
	tc, _ := strconv.Atoi(tcStr[:len(tcStr)-1])
	for i := 0; i < tc; i++ {
		nStr, _ := reader.ReadString('\n')
		n, _ := strconv.Atoi(nStr[:len(nStr)-1])
		if isHappy(n) {
			fmt.Println("true")
		} else {
			fmt.Println("false")
		}
	}
}
