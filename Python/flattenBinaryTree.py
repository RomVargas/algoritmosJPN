"""
<div class="html">
<p>
  Write a function that takes in a Binary Tree, flattens it, and returns its
  leftmost node.
</p>
<p>
  A flattened Binary Tree is a structure that's nearly identical to a Doubly
  Linked List (except that nodes have <span>left</span> and
  <span>right</span> pointers instead of <span>prev</span> and
  <span>next</span> pointers), where nodes follow the original tree's
  left-to-right order.
</p>
<p>
  Note that if the input Binary Tree happens to be a valid Binary Search Tree,
  the nodes in the flattened tree will be sorted.
</p>
<p>
  The flattening should be done in place, meaning that the original data
  structure should be mutated (no new structure should be created).
</p>
<p>
  Each <span>BinaryTree</span> node has an integer <span>value</span>, a
  <span>left</span> child node, and a <span>right</span> child node. Children
  nodes can either be <span>BinaryTree</span> nodes themselves or
  <span>None</span> / <span>null</span>.
</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">tree</span> =      1
         /     \
        2       3
      /   \   /
     4     5 6
          / \
         7   8
</pre>
<h3>Sample Output</h3>
<pre>4 &lt;-&gt; 2 &lt;-&gt; 7 &lt;-&gt; 5 &lt;-&gt; 8 &lt;-&gt; 1 &lt;-&gt; 6 &lt;-&gt; 3 <span class="CodeEditor-promptComment">// the leftmost node with value 4</span>
</pre>
</div>
"""
class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def flattenBinaryTree(root):
    inOrderNodes = getNodesInOrder(root, [])
    for i in range(0, len(inOrderNodes) - 1):
        leftNode = inOrderNodes[i]
        rightNode = inOrderNodes[i + 1]
        leftNode.right = rightNode
        rightNode.left = leftNode
    return inOrderNodes[0]

def getNodesInOrder(tree, array):
    if tree is not None:
        getNodesInOrder(tree.left, array)
        array.append(tree)
        getNodesInOrder(tree.right, array)
    return array
        