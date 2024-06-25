"""
<div class="html">
  <p>
    Write a function that takes in a positive integer
    <span>numberOfTags</span> and returns a list of all the valid strings that
    you can generate with that number of matched
    <span>&lt;div&gt;&lt;/div&gt;</span> tags.
  </p>
  <p>
    A string is valid and contains matched
    <span>&lt;div&gt;&lt;/div&gt;</span> tags if for every opening tag
    <span>&lt;div&gt;</span>, there's a closing tag <span>&lt;/div&gt;</span>
    that comes after the opening tag and that isn't used as a closing tag for
    another opening tag. Each output string should contain exactly
    <span>numberOfTags</span> opening tags and <span>numberOfTags</span> closing
    tags.
  </p>
  <p>
    For example, given <span>numberOfTags = 2</span>, the valid strings to
    return would be: <span>["&lt;div&gt;&lt;/div&gt;&lt;div&gt;&lt;/div&gt;", "&lt;div&gt;&lt;div&gt;&lt;/div&gt;&lt;/div&gt;"]</span>.
  </p>
  <p>Note that the output strings don't need to be in any particular order.</p>
  <h3>Sample Input</h3>
  <pre><span class="CodeEditor-promptParameter">numberOfTags</span> = 3
</pre>
  <h3>Sample Output</h3>
  <pre>  [
    "&lt;div&gt;&lt;div&gt;&lt;div&gt;&lt;/div&gt;&lt;/div&gt;&lt;/div&gt;",
    "&lt;div&gt;&lt;div&gt;&lt;/div&gt;&lt;div&gt;&lt;/div&gt;&lt;/div&gt;",
    "&lt;div&gt;&lt;div&gt;&lt;/div&gt;&lt;/div&gt;&lt;div&gt;&lt;/div&gt;",
    "&lt;div&gt;&lt;/div&gt;&lt;div&gt;&lt;div&gt;&lt;/div&gt;&lt;/div&gt;",
    "&lt;div&gt;&lt;/div&gt;&lt;div&gt;&lt;/div&gt;&lt;div&gt;&lt;/div&gt;",
  ] <span class="CodeEditor-promptComment">// The strings could be ordered differently.</span>
</pre>
</div>
"""


def generateDivTags(numberOfTags):
    matchedDivTags = []
    generateDivTagsFromPrefix(numberOfTags, numberOfTags, "", matchedDivTags)
    return matchedDivTags



def generateDivTagsFromPrefix(openingTagsNeeded, closingTagsNeeded, prefix, result):
    if openingTagsNeeded > 0:
        newPrefix = prefix + "<div>"
        generateDivTagsFromPrefix(openingTagsNeeded - 1, closingTagsNeeded, newPrefix, result)

    if openingTagsNeeded < closingTagsNeeded:
        newPrefix = prefix + "</div>"
        generateDivTagsFromPrefix(openingTagsNeeded, closingTagsNeeded - 1, newPrefix, result)

    if closingTagsNeeded == 0:
        result.append(prefix)