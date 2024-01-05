package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func isIsomorphic(s, t string) bool {
	if len(s) != len(t) {
		return false
	}
	mapST := make(map[rune]rune)
	mapTS := make(map[rune]rune)
	for i, sch := range s {
		tch := rune(t[i])
		if mapped, exists := mapST[sch]; exists {
			if mapped != tch {
				return false
			}
		} else if _, exists := mapTS[tch]; exists {
			return false
		} else {
			mapST[sch] = tch
			mapTS[tch] = sch
		}
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
		fmt.Println(isIsomorphic(s, t))
	}
}
