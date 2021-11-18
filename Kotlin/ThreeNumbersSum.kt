package com.algoexpert.program
// O(n^2) time | O(n) space
fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    array.sort()
	val triplets = mutableListOf<MutableList<Int>>()
	for (i in 0 until array.size - 2) {
		var left = i + 1
		var right = array.size - 1
		while (left < right) {
			val currentSum = array[i] + array[left] + array[right]
			if(currentSum == targetSum){
				triplets.add(mutableListOf(array[i], array[left], array[right]))
				left++
				right--
			} else if (currentSum < targetSum){
				left++
			} else if (currentSum > targetSum){
				right--
			}
		}
	}
    return triplets
}
