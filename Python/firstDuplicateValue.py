def firstDuplicateValue(array):
    """
    The function `firstDuplicateValue` finds and returns the first duplicate value in an array, or -1 if
    there are no duplicates.
    
    @param array The `firstDuplicateValue` function takes an array as input and returns the first
    duplicate value found in the array. If there are no duplicates, it returns -1.
    @return The function `firstDuplicateValue` returns the first duplicate value found in the input
    array. If no duplicates are found, it returns -1.
    """
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