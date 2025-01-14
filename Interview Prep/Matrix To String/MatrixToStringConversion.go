package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

// matrixToStringConversion converts a matrix to an array of strings
func matrixToStringConversion(matrix [][]int, M, N int) []string {
	result := make([]string, M)
	for i := 0; i < M; i++ {
		rowString := strings.Builder{}
		for j := 0; j < N; j++ {
			if matrix[i][j] == 0 {
				rowString.WriteByte('.')
			} else {
				rowString.WriteByte(byte(matrix[i][j] + 64))
			}
		}
		result[i] = rowString.String()
	}
	return result
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	tcStr, _ := reader.ReadString('\n')
	tc, _ := strconv.Atoi(strings.TrimSpace(tcStr))
	for t := 0; t < tc; t++ {
		line, _ := reader.ReadString('\n')
		parts := strings.Fields(line)
		M, _ := strconv.Atoi(parts[0])
		N, _ := strconv.Atoi(parts[1])
		matrix := make([][]int, M)
		for i := 0; i < M; i++ {
			matrix[i] = make([]int, N)
			rowLine, _ := reader.ReadString('\n')
			rowParts := strings.Fields(rowLine)
			for j := 0; j < N; j++ {
				matrix[i][j], _ = strconv.Atoi(rowParts[j])
			}
		}
		result := matrixToStringConversion(matrix, M, N)
		for _, row := range result {
			fmt.Println(row)
		}
	}
}
