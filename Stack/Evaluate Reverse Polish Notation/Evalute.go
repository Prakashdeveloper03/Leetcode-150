package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func evalRPN(tokens []string) int {
	stack := []int{}
	for _, token := range tokens {
		switch token {
		case "+":
			val1 := stack[len(stack)-1]
			val2 := stack[len(stack)-2]
			stack = stack[:len(stack)-2]
			stack = append(stack, val2+val1)
		case "-":
			val1 := stack[len(stack)-1]
			val2 := stack[len(stack)-2]
			stack = stack[:len(stack)-2]
			stack = append(stack, val2-val1)
		case "*":
			val1 := stack[len(stack)-1]
			val2 := stack[len(stack)-2]
			stack = stack[:len(stack)-2]
			stack = append(stack, val2*val1)
		case "/":
			val1 := stack[len(stack)-1]
			val2 := stack[len(stack)-2]
			stack = stack[:len(stack)-2]
			stack = append(stack, val2/val1)
		default:
			num, _ := strconv.Atoi(token)
			stack = append(stack, num)
		}
	}
	return stack[0]
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	tc, _ := strconv.Atoi(scanner.Text())
	for t := 0; t < tc; t++ {
		scanner.Scan()
		n, _ := strconv.Atoi(scanner.Text())
		tokens := make([]string, n)
		for i := 0; i < n; i++ {
			scanner.Scan()
			tokens[i] = scanner.Text()
		}
		fmt.Println(evalRPN(tokens))
	}
}
