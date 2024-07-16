"""
<div class="html">
<p>
  The distance between a node in a Binary Tree and the tree's root is called the
  node's depth.
</p>
<p>
  Write a function that takes in a Binary Tree and returns the sum of all of
  its subtrees' nodes' depths.
</p>
<p>
  Each <span>BinaryTree</span> node has an integer <span>value</span>, a
  <span>left</span> child node, and a <span>right</span> child node. Children
  nodes can either be <span>BinaryTree</span> nodes themselves or
  <span>None</span> / <span>null</span>.
</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">tree</span> =    1
       /     \
      2       3
    /   \   /   \
   4     5 6     7
 /   \
8     9
</pre>
<h3>Sample Output</h3>
<pre>26
<span class="CodeEditor-promptComment">// The sum of the root tree's node depths is 16.</span>
<span class="CodeEditor-promptComment">// The sum of the tree rooted at 2's node depths is 6.</span>
<span class="CodeEditor-promptComment">// The sum of the tree rooted at 3's node depths is 2.</span>
<span class="CodeEditor-promptComment">// The sum of the tree rooted at 4's node depths is 2.</span>
<span class="CodeEditor-promptComment">// Summing all of these sums yields 26.</span>
</pre>
</div>
"""


def allKindsOfNodeDepths(root):
    if root is None:
        return 0
    return allKindsOfNodeDepths(root.left) + allKindsOfNodeDepths(root.right) + nodeDepths(root)

def nodeDepths(node, depth=0):
    if node is None: 
         return 0
    return depth + nodeDepths(node.left, depth + 1) + nodeDepths(node.right, depth + 1)


# This is the class of the input binary tree.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
