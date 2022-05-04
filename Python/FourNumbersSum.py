#average: O(n^2) time | O(n^2) space
#Worst: O(n^3) time | O(n^2) space
def fourNumberSum(array, targetSum):
    allPairSum = {}
    quadruplets = []
    import ipdb
    ipdb.set_trace()
    for i in range(1, len(array) - 1):
        print(i)
        for j in range(i + 1, len(array)):
            print(j)
            currentSum = array[i] + array[j]
            difference = targetSum - currentSum
            if difference in allPairSum:
                for pair in allPairSum[difference]:
                    quadruplets.append(pair + [array[i], array[j]])
        for k in range(0, i):
            currentSum = array[i] + array[k]
            if currentSum not in allPairSum:
                allPairSum[currentSum] = [[array[k], array[i]]]
            else:
                allPairSum[currentSum].append([array[k], array[i]])
    print(quadruplets)
    return quadruplets

array = [1,3,5,7,9,12,33]

fourNumberSum(array,61)