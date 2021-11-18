package main
import "sort"

// O(nlog(n)) time | O(1) space
func TwoNumberSum(array []int, target int) []int {
	sort.Ints(array)
	left, right := 0, len(array)-1
	for left < right {
		currentSum := array[left] + array[right]
		if currentSum == target {
			return []int {array[left], array[right]}
		} else if currentSum < target {
			left += 1
		} else {
			right -= 1
		}
	}
	return []int{}
}

// O (n^2) time | O(1) space
func TwoNumberSum2(array []int, target int) []int {
	for i := 0; i < len(array)-1; i++ {
		firstNum := array[i]
		for j := i + 1; j < len(array); j++ {
			secondNum := array[j]
			if firstNum+secondNum == target {
				return []int{firstNum, secondNum}
			}
		}
	}
	return []int{}
}

func TwoNumberSum3(array []int, target int) []int {
	nums := map[int]bool{}
	for _, num := range array {
		potentialMatch := target - num
		if _, found := nums[potentialMatch]; found {
			return []int{ potentialMatch, num}
		}
		nums[num] = true
	}
	return []int{}
}