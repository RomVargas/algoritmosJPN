def moveElementToEnd(array, toMove):
    """
    We start two pointers at the beginning and end of the array, and move them towards each other,
    swapping the elements they point to if the left pointer is pointing to the element we're looking
    for, and the right pointer isn't
    
    :param array: an array of integers
    :param toMove: the element to move to the end of the array
    :return: The array with the elements that are equal to toMove moved to the end of the array.
    """
    i = 0
    j = len(array) - 1
    while i < j:
        while i < j and array[j] == toMove:
            j -= 1
        if array[i] == toMove:
            array[i], array[j] = array[j], array[i]
        i += 1
    return array