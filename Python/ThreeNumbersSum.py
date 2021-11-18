# O(n^2) time | O(n) space
def threeNumbersSum(array, targetSum):
    array.sort()
    triplets = []
    for i in range(len(array) - 1):
        left = i + 1
        right = len(array) -1
        while left < right:
            currentSum = array[i] + array[left] + array[right]
            if currentSum == targetSum:
                triplets.append([array[i], array[left], array[right]])
                left += 1
                right -= 1
            elif currentSum < targetSum:
                left += 1
            elif currentSum > targetSum:
                right -= 1
    return triplets

nums = [1,3,4,5,8,-1,-4]

print(threeNumbersSum(nums, 9))