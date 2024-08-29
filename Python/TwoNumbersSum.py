#O(n^2) time | O(1) space
def twoNumbersSum(array, targetSum):
    for x in range(len(array) -1):
        firstNum = array[x]
        for y in range(x + 1, len(array)):
            secondNum = array[y]
            if firstNum + secondNum == targetSum:
                return [firstNum, secondNum]
    return []

# O(n) time | O(n) sapce
    """
    This Python function finds two numbers in an array that sum up to a target sum using a hash table to
    store previously seen numbers.
    
    @param array The `array` parameter is a list of integers where we are searching for two numbers that
    add up to the `targetSum`.
    @param targetSum The `targetSum` parameter is the sum that we are trying to find by adding two
    numbers from the `array`. The function `twoNumbersSum2` takes an `array` of integers and a
    `targetSum` as input, and it returns a pair of numbers from the `array`
    @return The function `twoNumbersSum2` returns a list containing two numbers that add up to the
    `targetSum`. If no such pair is found, an empty list is returned.
    """
def twoNumbersSum2(array, targetSum):
    nums = {}
    for num in array:
        potentialMatch = targetSum - num
        if potentialMatch in nums:
            return [potentialMatch, num]
        else:
            nums[num] = True
    return []

# O(nlog(n)) time | O(1) space
def twoNumbersSum3(array, targetSum):
    array.sort()
    left = 0
    right = len(array) -1
    while left < right:
        currentSum = array[left] + array[right]
        if currentSum == targetSum:
            return [array[left], array[right]]
        elif currentSum < targetSum:
            left += 1
        elif currentSum > targetSum:
            right -= -1
    return []

nums = [1,3,4,5,8,-1,-4]

print(twoNumbersSum(nums, 13))
print(twoNumbersSum2(nums, 12))
print(twoNumbersSum3(nums, 13))