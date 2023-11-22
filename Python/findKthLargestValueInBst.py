"""
<div class="html">
<p>
  Write a function that takes in a Binary Search Tree (BST) and a positive
  integer <span>k</span> and returns the kth largest integer contained in the
  BST.
</p>
<p>
  You can assume that there will only be integer values in the BST and that
  <span>k</span> is less than or equal to the number of nodes in the tree.
</p>
<p>
  Also, for the purpose of this question, duplicate integers will be treated as
  distinct values. In other words, the second largest value in a BST containing
  values <span>{5, 7, 7}</span> will be <span>7</span>—not <span>5</span>.
</p>
<p>
  Each <span>BST</span> node has an integer <span>value</span>, a
  <span>left</span> child node, and a <span>right</span> child node. A node is
  said to be a valid <span>BST</span> node if and only if it satisfies the BST
  property: its <span>value</span> is strictly greater than the values of every
  node to its left; its <span>value</span> is less than or equal to the values
  of every node to its right; and its children nodes are either valid
  <span>BST</span> nodes themselves or <span>None</span> / <span>null</span>.
</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">tree</span> =   15
       /     \
      5      20
    /   \   /   \
   2     5 17   22
 /   \         
1     3       
<span class="CodeEditor-promptParameter">k</span> = 3
</pre>
<h3>Sample Output</h3>
<pre>17</pre>
</div> 
"""

class BST:
    """
    We traverse the tree in order, and store the values in an array. 
    
    We then return the kth largest value in the array.
    
    :param tree: The root node of a BST
    :param k: The kth largest value we're looking for
    :return: The kth largest value in the BST.
    """
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

def findKthLargestValueInBst(tree, k):
    """
    We traverse the tree in order, and store the values in an array. Then we return the kth largest
    value in the array
    
    :param tree: a BST
    :param k: The kth largest value we're looking for
    :return: The kth largest value in the BST.
    """
    sortedNodeValues = []
    inOrderTraverse(tree, sortedNodeValues)
    return sortedNodeValues[len(sortedNodeValues) - k]

def inOrderTraverse(node, sortedNodeValues):
    """
    If the node is not null, traverse the left subtree, append the node's value to the list, and then
    traverse the right subtree
    
    :param node: the current node we're looking at
    :param sortedNodeValues: This is an empty list that we will use to store the values of the nodes in
    the tree
    :return: The sortedNodeValues list is being returned.
    """
    if node is None:
        return

    inOrderTraverse(node.left, sortedNodeValues)
    sortedNodeValues.append(node.value)
    inOrderTraverse(node.right, sortedNodeValues)