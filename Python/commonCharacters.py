"""<div class="html">
  <p>
    Write a function that takes in a non-empty list of non-empty strings and
    returns a list of characters that are common to all strings in the list,
    ignoring multiplicity.
  </p>

  <p>
    Note that the strings are not guaranteed to only contain alphanumeric characters. The list
    you return can be in any order.
  </p>

  <h3>Sample Input</h3>
  <pre><span class="CodeEditor-promptParameter">strings</span> = ["abc", "bcd", "cbaccd"]
</pre>
  <h3>Sample Output</h3>
  <pre>["b", "c"] <span class="CodeEditor-promptComment">// The characters could be ordered differently.</span>
</pre>
</div>"""

def commonCharacters(strings):
    characterCounts = {}
    for string in strings:
        uniqueStringCharacters = set(string)
        for character in uniqueStringCharacters:
            if character not in characterCounts:
                characterCounts[character] = 0
            characterCounts[character] += 1

    finalCharacters = []
    for character, count in characterCounts.items():
        if count == len(strings):
            finalCharacters.append(character)
    
    return finalCharacters