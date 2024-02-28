"""
<div class="html">
<p>
  Write a function that takes in a Binary Tree, transforms it into a Right
  Sibling Tree, and returns its root.
</p>
<p>
  A Right Sibling Tree is obtained by making every node in a Binary Tree have
  its <span>right</span> property point to its right sibling instead of its
  right child. A node's right sibling is the node immediately to its right on
  the same level or <span>None</span> / <span>null</span> if there is no node
  immediately to its right.
</p>
<p>
  Note that once the transformation is complete, some nodes might no longer have
  a node pointing to them. For example, in the sample output below, the node
  with value <span>10</span> no longer has any inbound pointers and is
  effectively unreachable.
</p>
<p>
  The transformation should be done in place, meaning that the original data
  structure should be mutated (no new structure should be created).
</p>
<p>
  Each <span>BinaryTree</span> node has an integer <span>value</span>, a
  <span>left</span> child node, and a <span>right</span> child node. Children
  nodes can either be <span>BinaryTree</span> nodes themselves or
  <span>None</span> / <span>null</span>.
</p>
<h3>Sample Input</h3>
<pre style="position: relative;"><span class="CodeEditor-promptParameter">tree</span> =     1
      /         \
     2           3
   /   \       /   \
  4     5     6     7
 / \     \   /     / \
8   9    10 11    12 13
           /
          14
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
<h3>Sample Output</h3>
<pre style="position: relative;">           1 <span class="CodeEditor-promptComment">// the root node with value 1</span>
      /
     2-----------3
   /           /
  4-----5-----6-----7
 /           /     /
8---9    10-11    12-13 <span class="CodeEditor-promptComment">// the node with value 10 no longer has a node pointing to it</span>
           /
          14
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
</div>
"""
class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def rightSiblingTree(root):
    mutate (root, None, None)
    return root

def mutate(node, parent, isLeftChild):
    if node is None:
        return
    left, right = node.left, node.right
    mutate(left, node, True)
    if parent is None:
        node.right = None
    elif isLeftChild:
        node.right = parent.right
    else:
        if parent.right is None:
            node.right = None
        else: 
            node.right = parent.right.left
    mutate(right, node, False)
