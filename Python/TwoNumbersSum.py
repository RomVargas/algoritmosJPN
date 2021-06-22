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