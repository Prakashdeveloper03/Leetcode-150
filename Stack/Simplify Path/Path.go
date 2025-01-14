package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func simplifyPath(path string) string {
	stack := []string{}
	paths := strings.Split(path, "/")
	for _, part := range paths {
		if part == ".." {
			if len(stack) > 0 {
				stack = stack[:len(stack)-1]
			}
		} else if part != "" && part != "." {
			stack = append(stack, part)
		}
	}
	if len(stack) == 0 {
		return "/"
	}
	return "/" + strings.Join(stack, "/")
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	var tc int
	fmt.Sscanf(scanner.Text(), "%d", &tc)
	for i := 0; i < tc; i++ {
		scanner.Scan()
		path := scanner.Text()
		fmt.Println(simplifyPath(path))
	}
}
