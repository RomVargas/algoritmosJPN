"""
<div class="html">
<p>
  An array of integers is said to represent the Binary Search Tree (BST)
  obtained by inserting each integer in the array, from left to right, into the
  BST.
</p>
<p>
  Write a function that takes in two arrays of integers and determines whether
  these arrays represent the same BST. Note that you're <i>not</i> allowed to
  construct any BSTs in your code.
</p>
<p>
  A BST is a Binary Tree that consists only of <span>BST</span> nodes. A node is said to be a
  valid <span>BST</span> node if and only if it satisfies the BST property: its value is
  strictly greater than the values of every node to its left; its value is less
  than or equal to the values of every node to its right; and its children nodes
  are either valid <span>BST</span> nodes themselves or <span>None</span> /
  <span>null</span>.
</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">arrayOne</span> = [10, 15, 8, 12, 94, 81, 5, 2, 11]
<span class="CodeEditor-promptParameter">arrayTwo</span> = [10, 8, 5, 15, 2, 12, 11, 94, 81]
</pre>
<h3>Sample Output</h3>
<pre>true <span class="CodeEditor-promptComment">// both arrays represent the BST below</span>
<span class="CodeEditor-promptComment">         10
       /     \
      8      15
    /       /   \
   5      12    94
 /       /     /
2       11    81
</span>
</pre>
</div>
"""

def sameBsts(arrayOne, arrayTwo):
    if len(arrayOne) != len(arrayTwo):
        return False

    if len(arrayOne) == 0 and len(arrayTwo) == 0:
        return True

    if arrayOne[0] != arrayTwo[0]:
        return False

    leftOne = getSmaller(arrayOne)
    leftTwo = getSmaller(arrayTwo)
    rightOne = getBiggerOrEqual(arrayOne)
    rightTwo = getBiggerOrEqual(arrayTwo)

    return sameBsts(leftOne, leftTwo) and sameBsts(rightOne, rightTwo)

def getSmaller(array):
    smaller = []
    for i in range(1, len(array)):
        if array[i] < array[0]:
            smaller.append(array[i])
    return smaller

def getBiggerOrEqual(array):
    biggerOrEqual = []
    for i in range(1, len(array)):
        if array[i] >= array[0]:
            biggerOrEqual.append(array[i])
    return biggerOrEqual