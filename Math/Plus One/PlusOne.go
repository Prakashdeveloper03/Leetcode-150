package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func plusOne(digits []int) []int {
	for i := len(digits) - 1; i >= 0; i-- {
		if digits[i]+1 != 10 {
			digits[i]++
			return digits
		}
		digits[i] = 0
	}
	newDigits := make([]int, len(digits)+1)
	newDigits[0] = 1
	return newDigits
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	tcStr, _ := reader.ReadString('\n')
	tc, _ := strconv.Atoi(strings.TrimSpace(tcStr))
	for t := 0; t < tc; t++ {
		nStr, _ := reader.ReadString('\n')
		n, _ := strconv.Atoi(strings.TrimSpace(nStr))
		digitsStr, _ := reader.ReadString('\n')
		digitsStr = strings.TrimSpace(digitsStr)
		digitParts := strings.Split(digitsStr, " ")
		digits := make([]int, n)
		for i := 0; i < n; i++ {
			digits[i], _ = strconv.Atoi(digitParts[i])
		}
		result := plusOne(digits)
		fmt.Println(result)
	}
}
