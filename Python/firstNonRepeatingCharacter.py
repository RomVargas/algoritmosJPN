def firstNonRepeatingCharacter(string):
    """
    For each character in the string, check if it's a duplicate of any other character in the string. If
    it's not, return the index of the character. If it is, continue. If no character is found that is
    not a duplicate, return -1
    
    :param string: a string of lowercase letters
    :return: The index of the first non-repeating character in the string.
    """
    for idx in range(len(string)):
        foundDuplicate = False
        for idx2 in range(len(string)):
            if string[idx] == string[idx2] and idx != idx2:
                foundDuplicate = True

        if not foundDuplicate:
            return idx

    return -1