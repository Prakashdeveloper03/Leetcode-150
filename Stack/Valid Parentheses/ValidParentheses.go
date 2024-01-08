package main

import (
	"bufio"
	"fmt"
	"os"
)

func isValid(s string) bool {
	stack := []rune{}
	bracketLookup := map[rune]rune{
		')': '(',
		'}': '{',
		']': '[',
	}
	for _, c := range s {
		if opening, exists := bracketLookup[c]; exists {
			if len(stack) > 0 && stack[len(stack)-1] == opening {
				stack = stack[:len(stack)-1]
			} else {
				return false
			}
		} else {
			stack = append(stack, c)
		}
	}

	return len(stack) == 0
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	var tc int
	fmt.Sscanf(scanner.Text(), "%d", &tc)
	for i := 0; i < tc; i++ {
		scanner.Scan()
		s := scanner.Text()
		fmt.Println(isValid(s))
	}
}
