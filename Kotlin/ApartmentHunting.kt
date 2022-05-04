package com.algoexpert.program

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun apartmentHunting(blocks: List<Map<String, Boolean>>, reqs: List<String>): Int {
    val maxDistancesAtBlocks = MutableList(blocks.size) { Int.MIN_VALUE }
	for (i in 0 until blocks.size) {
		for (req in reqs) {
			var closestReqDistance = Int.MAX_VALUE
			for (j in 0 until blocks.size) {
				if (blocks[j].containsKey(req) && blocks[j][req]!!) {
					closestReqDistance = min(closestReqDistance, distanceBetween(i, j)) 
				}
			}
			maxDistancesAtBlocks[i] = max(maxDistancesAtBlocks[i], closestReqDistance)
		}
	}
	return getIdxAtMinValue(maxDistancesAtBlocks)
}

fun getIdxAtMinValue(array: MutableList<Int>): Int {
	var idxAtMinValue = 0
	var minValue = Int.MAX_VALUE
	for (i in 0 until array.size) {
		val currentValue = array[i]
		if (currentValue < minValue) {
			minValue = currentValue
			idxAtMinValue = i
		}
	}
	return idxAtMinValue
}

fun distanceBetween(a: Int, b: Int): Int {
	return abs(a - b)
}