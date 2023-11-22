"""
<div class="html">
<p>
  You're given the root node of a Binary Tree. Write a function that returns
  <span>true</span> if this Binary Tree is height balanced and
  <span>false</span> if it isn't.
</p>
<p>
  A Binary Tree is height balanced if for each node in the tree, the difference
  between the height of its left subtree and the height of its right subtree is
  at most <span>1</span>.
</p>
<p>
  Each <span>BinaryTree</span> node has an integer <span>value</span>, a
  <span>left</span> child node, and a <span>right</span> child node. Children
  nodes can either be <span>BinaryTree</span> nodes themselves or
  <span>None</span> / <span>null</span>.
</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">tree</span> = 1
     /   \
    2     3
  /   \     \
 4     5     6
     /   \
    7     8
</pre>
<h3>Sample Output</h3>
<pre>true
</pre>
</div>
"""

# This is an input class. Do not edit.
class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

class TreeInfo:
    def __init__(self, isBalanced, height):
        self.isBalanced = isBalanced
        self.height = height
# O(n) time | O(h) space - donde n es el numero de nodos en el arbol binario
def heightBalancedBinaryTree(tree):
    treeInfo = getTreeInfo(tree)
    return treeInfo.isBalanced

def getTreeInfo(node):
    if node is None:
        return TreeInfo(True, -1)

    leftSubtreeInfo = getTreeInfo(node.left)
    rightSubtreeInfo = getTreeInfo(node.right)

    isBalanced = (
        leftSubtreeInfo.isBalanced
        and rightSubtreeInfo.isBalanced
        and abs(leftSubtreeInfo.height - rightSubtreeInfo.height) <= 1
    )
    height = max(leftSubtreeInfo.height, rightSubtreeInfo.height) + 1
    return TreeInfo(isBalanced, height)