def furthest_identical_digrams(S):
    """
    It creates a list of all the digrams in the string, then iterates over all pairs of digrams, and
    returns the maximum distance between any two identical digrams
    
    :param S: a string
    :return: The maximum distance between two identical digrams in the string S.
    """
    digrams = [S[i:i+2] for i in range(len(S)-1)]
    max_distance = -1
    for i in range(len(digrams)):
        for j in range(i+1, len(digrams)):
            if digrams[i] == digrams[j]:
                distance = j - i
                if distance > max_distance:
                    max_distance = distance
    return max_distance
