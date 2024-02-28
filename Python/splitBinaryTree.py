"""
<div class="html">
<p>
  Write a function that takes in a Binary Tree with at least one node and
  checks if that Binary Tree can be split into two Binary Trees of equal sum by
  removing a single edge. If this split is possible, return the new sum of each
  Binary Tree, otherwise return 0. Note that you do not need to return the edge
  that was removed.
</p>
<p>
  The sum of a Binary Tree is the sum of all values in that Binary Tree.
</p>
<p>
  Each <span>BinaryTree</span> node has an integer <span>value</span>, a
  <span>left</span> child node, and a <span>right</span> child node. Children
  nodes can either be <span>BinaryTree</span> nodes themselves or
  <span>None</span> / <span>null</span>.
</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">tree</span> =     1
        /     \
       3       -2
     /   \    /  \
    6    -5  5    2
  /
 2
</pre>
<h3>Sample Output</h3>
<pre>6 <span class="CodeEditor-promptComment">// Remove the edge to the left of the root node,
// creating two trees, each with sums of 6</span>
</pre>
</div> 
"""

# This is an input class. Do not edit.
class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def splitBinaryTree(tree):
    desiredSubtreeSum = getTreeSum(tree)  / 2
    canBeSplit = trySubtrees(tree, desiredSubtreeSum)[1]
    return desiredSubtreeSum if canBeSplit else 0

def trySubtrees(tree, desiredSubtreeSum):
    if tree is None:
        return(0, False)

    leftSum, leftCanBeSplit = trySubtrees(tree.left, desiredSubtreeSum)
    rightSum, rightCanBeSplit = trySubtrees(tree.right, desiredSubtreeSum)

    currentTreeSum = tree.value + leftSum + rightSum
    canBeSplit = leftCanBeSplit or rightCanBeSplit or currentTreeSum == desiredSubtreeSum
    return ( currentTreeSum, canBeSplit)
    
def getTreeSum(tree):
    if tree is None:
        return 0
    return tree.value + getTreeSum(tree.left) + getTreeSum(tree.right)
    
