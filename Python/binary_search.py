"""
    We start with the entire array and keep cutting it in half until we find the target or we run out of
    elements to search
    
    :param array: the array to search through
    :param target: the value we're searching for
    :return: The index of the target value in the array.
"""
def binary_search(array, target):
    low = 0
    high = len(array) - 1
    while low <= high:
        mid = (low + high) // 2
        if array[mid] == target:
            return mid
        elif array[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1

    def bubble_sort(array):
        """
        For each element in the array, starting from the end, compare it to the element next to it. If
        the element is greater than the next element, swap them
        
        :param array: the array to be sorted
        :return: The array is being returned.
        """
        for i in range(len(array) - 1, 0, -1):
            for j in range(i):
                if array[j] > array[j + 1]:
                    array[j], array[j + 1] = array[j + 1], array[j]
        return array
