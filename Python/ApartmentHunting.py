"""
  You're looking to move into a new apartment on specific street, and you're
  given a list of contiguous blocks on that street where each block contains an
  apartment that you could move into.

  You also have a list of requirements: a list of buildings that are important
  to you. For instance, you might value having a school and a gym near your
  apartment. The list of blocks that you have contains information at every
  block about all of the buildings that are present and absent at the block in
  question. For instance, for every block, you might know whether a school, a
  pool, an office, and a gym are present.

  In order to optimize your life, you want to pick an apartment block such that
  you minimize the farthest distance you'd have to walk from your apartment to
  reach any of your required buildings.

  Write a function that takes in a list of contiguous blocks on a specific
  street and a list of your required buildings and that returns the location
  (the index) of the block that's most optimal for you.

  If there are multiple most optimal blocks, your function can return the index
  of any one of them.
"""

def apartmentHunting(blocks, reqs):
    # Write your code here.
	maxDistancesAtBlocks = [float("-inf") for block in blocks]
	for i in range(len(blocks)):
		for req in reqs:
			closestReqDistance = float("inf")
			for j in range(len(blocks)):
				if blocks[j][req]:
					closestReqDistance = min (closestReqDistance, distanceBetween(i,j))
			maxDistancesAtBlocks[i] = max(maxDistancesAtBlocks[i],closestReqDistance)
	return getIdxAtMinValue(maxDistancesAtBlocks)

def getIdxAtMinValue(array):
	idxAtMinValue = 0
	minValue = float("inf")
	for i in range(len(array)):
		currentValue = array[i]
		if currentValue < minValue:
			minValue = currentValue
			idxAtMinValue = i
	return idxAtMinValue

def distanceBetween(a, b):
	return abs(a - b)

blocks = [
            {"gym": False, "school": True, "store": False},
            {"gym": True, "school": False, "store": False},
            {"gym": True, "school": True, "store": False},
            {"gym": False, "school": True, "store": False},
            {"gym": False, "school": True, "store": True},
        ]
reqs = ["gym", "school", "store"]