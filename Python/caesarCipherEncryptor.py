def caesarCipherEncryptor(string, key):
    newLetters = []
    newKey = key 
    alphabet = list('abcdefghijklmnopqrstuvwxyz')
    for letter in string:
        newLetters.append(getNewLetter(letter, newKey, alphabet))
    return "".join(newLetters)

def getNewLetter(letter, key, alphabet):
    newLetterCode = alphabet.index(letter) + key
    return alphabet[newLetterCode % 26]