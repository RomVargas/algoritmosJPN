def generateDocument(characters, document):
    """
    If the frequency of a character in the document is greater than the frequency of the character in
    the characters, then return false. Otherwise, return true
    
    :param characters: a string of characters
    :param document: a string representing the document you want to generate
    :return: a boolean value.
    """
    for character in document:
        documentFrequency = countCharacterFrequency(character, document)
        charactersFrequency = countCharacterFrequency(character, characters)
        if documentFrequency > charactersFrequency:
            return False
    return True


def countCharacterFrequency(character, target):
    """
    "For each character in the target string, if the character is equal to the character we're looking
    for, increment the frequency counter."
    
    Now, let's look at the same function in JavaScript:
    
    // JavaScript
    function countCharacterFrequency(character, target) {
        var frequency = 0;
        for (var i = 0; i < target.length; i++) {
            if (target[i] === character) {
                frequency++;
            }
        }
    
        return frequency;
    }
    
    :param character: The character you want to count the frequency of
    :param target: The string to be searched
    :return: The number of times the character appears in the target string.
    """
    frequency = 0
    for char in target:
        if char == character:
            frequency += 1

    return frequency