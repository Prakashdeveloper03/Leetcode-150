package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Pair struct {
	val      int
	minValue int
}

type MinStack struct {
	stack []Pair
}

func Constructor() *MinStack {
	return &MinStack{stack: []Pair{}}
}

func (ms *MinStack) Push(val int) {
	if len(ms.stack) == 0 {
		ms.stack = append(ms.stack, Pair{val: val, minValue: val})
	} else {
		currentMin := ms.stack[len(ms.stack)-1].minValue
		ms.stack = append(ms.stack, Pair{val: val, minValue: min(val, currentMin)})
	}
}

func (ms *MinStack) Pop() {
	if len(ms.stack) > 0 {
		ms.stack = ms.stack[:len(ms.stack)-1]
	}
}

func (ms *MinStack) Top() int {
	if len(ms.stack) > 0 {
		return ms.stack[len(ms.stack)-1].val
	}
	panic("Stack is empty")
}

func (ms *MinStack) GetMin() int {
	if len(ms.stack) > 0 {
		return ms.stack[len(ms.stack)-1].minValue
	}
	panic("Stack is empty")
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	operationsCount, _ := strconv.Atoi(scanner.Text())
	minStack := Constructor()
	for i := 0; i < operationsCount; i++ {
		fmt.Println("Enter operation (push <value> / pop / top / getMin):")
		scanner.Scan()
		command := strings.Split(scanner.Text(), " ")
		switch command[0] {
		case "push":
			val, _ := strconv.Atoi(command[1])
			minStack.Push(val)
			fmt.Println("Pushed:", val)
		case "pop":
			if len(minStack.stack) > 0 {
				minStack.Pop()
				fmt.Println("Popped top element")
			} else {
				fmt.Println("Stack is empty")
			}
		case "top":
			func() {
				defer func() {
					if r := recover(); r != nil {
						fmt.Println(r)
					}
				}()
				fmt.Println("Top element:", minStack.Top())
			}()
		case "getMin":
			func() {
				defer func() {
					if r := recover(); r != nil {
						fmt.Println(r)
					}
				}()
				fmt.Println("Minimum element:", minStack.GetMin())
			}()
		default:
			fmt.Println("Invalid command")
		}
	}
}
