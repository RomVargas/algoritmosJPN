package main

import "math"

type Block map[string]bool

func ApartmentHunting(blocks []Block, reqs []string) int {
	maxDistancesAtBlocks := make([]int, len(blocks))
	for i := range blocks {
		maxDistancesAtBlocks[i] = -1
		for _, req := range reqs {
			closestReqDistance := math.MaxInt32
			for j := range blocks {
				if blocks[j][req] {
					closestReqDistance = min(closestReqDistance, distanceBetween(i,j))
				}
			}
			maxDistancesAtBlocks[i] = max(maxDistancesAtBlocks[i], closestReqDistance)
		}
	}
	
	var optimalBlockIdx int
	smallestMaxDistance := math.MaxInt32
	for i, currentDistnace := range maxDistancesAtBlocks  {
		if currentDistnace < smallestMaxDistance {
			smallestMaxDistance = currentDistnace
			optimalBlockIdx = i
		}
	}
	return optimalBlockIdx
}

func distanceBetween(a, b int) int {
	if a > b {
		return a - b
	}
	return b - a
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

blocks := []Block{
		{
			"gym":    false,
			"school": true,
			"store":  false,
		},
		{
			"gym":    true,
			"school": false,
			"store":  false,
		},
		{
			"gym":    true,
			"school": true,
			"store":  false,
		},
		{
			"gym":    false,
			"school": true,
			"store":  false,
		},
		{
			"gym":    false,
			"school": true,
			"store":  true,
		},
	}
	reqs := []string{"gym", "school", "store"}
