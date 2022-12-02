def maxTrailing(arr):
    vmin = arr[0]
    dmax = 0
    for i in range(len(arr)):
        if (arr[i] < vmin):
            vmin = arr[i]
        elif (arr[i] - vmin > dmax):
            dmax = arr[i] - vmin
    if dmax == 0:
        return -1
            
    return dmax