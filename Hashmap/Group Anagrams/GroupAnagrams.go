package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

func groupAnagrams(strs []string) [][]string {
	anagramMap := make(map[string][]string)
	for _, str := range strs {
		sortedStr := sortString(str)
		anagramMap[sortedStr] = append(anagramMap[sortedStr], str)
	}
	var result [][]string
	for _, group := range anagramMap {
		result = append(result, group)
	}
	return result
}

func sortString(s string) string {
	runes := []rune(s)
	sort.Slice(runes, func(i, j int) bool {
		return runes[i] < runes[j]
	})
	return string(runes)
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	tcStr, _ := reader.ReadString('\n')
	tc, _ := strconv.Atoi(strings.TrimSpace(tcStr))
	for t := 0; t < tc; t++ {
		strsStr, _ := reader.ReadString('\n')
		strs := strings.Fields(strings.TrimSpace(strsStr))
		result := groupAnagrams(strs)
		for _, group := range result {
			fmt.Println(strings.Join(group, " "))
		}
		fmt.Println()
	}
}
