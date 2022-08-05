def selectionSort(array):
    idx = 0
    while idx < len(array) - 1:
        sidx = idx
        for i in range(idx, len(array)):
            if array[i] < array[sidx]:
                sidx = i
        array[idx], array[sidx] = array[sidx], array[idx]
        idx += 1
    return array