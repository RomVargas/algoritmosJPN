def firstDuplicateValue(array):
    minimumSeconIndex = len(array)
    for i in range(len(array)):
        value = array[i]
        for j  in range(i + 1, len(array)):
            valueToCompare = array[j]
            if value == valueToCompare:
                minimumSeconIndex = min(minimumSeconIndex, j)
                
    if minimumSeconIndex == len(array):
        return -1
        
    return array[minimumSeconIndex]