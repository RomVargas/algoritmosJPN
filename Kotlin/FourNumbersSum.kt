package com.algoexpert.program

fun fourNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    val allPairSums = mutableMapOf<Int, MutableList<MutableList<Int>>>()
	val quadruplets = mutableListOf<MutableList<Int>>()
	for (i in 1 until array.size - 1) {
		for(j in i + 1 until array.size) {
			val currentSum = array[i] + array[j]
			val difference = targetSum - currentSum
			if (allPairSums.containsKey(difference)) {
				for (pair in allPairSums[difference]!!) {
					val p = pair.toMutableList<Int>()
					p.add(array[i])
					p.add(array[j])
					quadruplets.add(p)
				}
			}
		}
		for (k in 0 until i) {
			val currentSum = array[i] + array[k]
			if(!allPairSums.containsKey(currentSum)) {
				allPairSums[currentSum] = mutableListOf<MutableList<Int>>()
				allPairSums[currentSum]!!.add(mutableListOf<Int>(array[k], array[i]))
			} else {
				allPairSums[currentSum]!!.add(mutableListOf<Int>(array[k], array[i]))
			}
		} 
	}
    return quadruplets
}