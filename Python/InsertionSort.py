def insertionSort(array):
    for i in range(len(array)):
        while i > 0 and array[i] < array[i - 1]:
            array[i - 1], array[i] = array[i], array[i - 1]
            i -= 1
    return array