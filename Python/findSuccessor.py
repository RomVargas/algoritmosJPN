"""
<div class="html">
<p>
  Write a function that takes in a Binary Tree (where nodes have an additional
  pointer to their parent node) as well as a node contained in that tree and
  returns the given node's successor.
</p>
<p>
  A node's successor is the next node to be visited (immediately after the given
  node) when traversing its tree using the in-order tree-traversal technique. A
  node has no successor if it's the last node to be visited in the in-order
  traversal.
</p>
<p>
  If a node has no successor, your function should return <span>None</span> /
  <span>null</span>.
</p>
<p>
  Each <span>BinaryTree</span> node has an integer <span>value</span>, a
  <span>parent</span> node, a <span>left</span> child node, and a
  <span>right</span> child node. Children nodes can either be
  <span>BinaryTree</span> nodes themselves or <span>None</span> /
  <span>null</span>.
</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">tree</span> = 
              1
            /   \
           2     3
         /   \ 
        4     5
       /       
      6  
<span class="CodeEditor-promptParameter">node</span> = 5   
</pre>
<h3>Sample Output</h3>
<pre>1
<span class="CodeEditor-promptComment">// This tree's in-order traversal order is:</span>
<span class="CodeEditor-promptComment">// 6 -&gt; 4 -&gt; 2 -&gt; 5 -&gt; 1 -&gt; 3 </span>
<span class="CodeEditor-promptComment">// 1 comes immediately after 5.</span>
</pre>
</div>
"""

class BinaryTree:
    def __init__(self, value, left=None, right=None, parent=None):
        self.value = value
        self.left = left
        self.right = right
        self.parent = parent


def findSuccessor(tree, node):
    inOrderTraversalOrder = getInOrderTraversalOrder(tree)

    for idx, currentNode in enumerate(inOrderTraversalOrder):
        if currentNode != node:
            continue

        if idx == len(inOrderTraversalOrder) - 1:
            return None

        return inOrderTraversalOrder[idx + 1]

def getInOrderTraversalOrder(node, order=[]):
    if node is None:
        return order

    getInOrderTraversalOrder(node.left, order)
    order.append(node)
    getInOrderTraversalOrder(node.right, order)

    return order
    