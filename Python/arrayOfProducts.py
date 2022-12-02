def arrayOfProducts(array):
    """
    For each element in the array, multiply all the other elements together and store the result in a
    new array
    
    :param array: an array of integers
    :return: [120, 60, 40, 30, 24]
    """
    products = [1 for _ in range(len(array))]

    for i in range(len(array)):
        runningProduct = 1
        for j in range(len(array)):
            if i != j:
                runningProduct *= array[j]
        products[i] = runningProduct

    return products