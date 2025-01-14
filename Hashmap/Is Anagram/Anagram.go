package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func isAnagram(s, t string) bool {
	if len(s) != len(t) {
		return false
	}
	countMap := make(map[rune]int)
	for _, c := range s {
		countMap[c]++
	}
	for _, c := range t {
		if countMap[c] == 0 {
			return false
		}
		countMap[c]--
	}

	return true
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	tcStr, _ := reader.ReadString('\n')
	tc, _ := strconv.Atoi(strings.TrimSpace(tcStr))
	for t := 0; t < tc; t++ {
		s, _ := reader.ReadString('\n')
		t, _ := reader.ReadString('\n')
		s = strings.TrimSpace(s)
		t = strings.TrimSpace(t)
		fmt.Println(isAnagram(s, t))
	}
}
