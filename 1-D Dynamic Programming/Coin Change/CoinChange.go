package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

func coinChange(coins []int, amount int) int {
	minCoins := make([]int, amount+1)
	for i := range minCoins {
		minCoins[i] = math.MaxInt32 - 1
	}
	minCoins[0] = 0
	for _, c := range coins {
		for i := c; i <= amount; i++ {
			if minCoins[i-c] != math.MaxInt32-1 {
				minCoins[i] = int(math.Min(float64(minCoins[i]), float64(minCoins[i-c]+1)))
			}
		}
	}
	if minCoins[amount] == math.MaxInt32-1 {
		return -1
	}
	return minCoins[amount]
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	tcStr, _ := reader.ReadString('\n')
	tc, _ := strconv.Atoi(strings.TrimSpace(tcStr))
	for t := 0; t < tc; t++ {
		nStr, _ := reader.ReadString('\n')
		n, _ := strconv.Atoi(strings.TrimSpace(nStr))
		coinsStr, _ := reader.ReadString('\n')
		coinsSlice := strings.Fields(coinsStr)
		coins := make([]int, n)
		for i := 0; i < n; i++ {
			coins[i], _ = strconv.Atoi(coinsSlice[i])
		}
		amountStr, _ := reader.ReadString('\n')
		amount, _ := strconv.Atoi(strings.TrimSpace(amountStr))
		fmt.Println(coinChange(coins, amount))
	}
}
