"""
<div class="html">
<p>
  You're given three nodes that are contained in the same Binary Search Tree:
  <span>nodeOne</span>, <span>nodeTwo</span>, and <span>nodeThree</span>. Write
  a function that returns a boolean representing whether one of
  <span>nodeOne</span> or <span>nodeThree</span> is an ancestor of
  <span>nodeTwo</span> and the other node is a descendant of
  <span>nodeTwo</span>. For example, if your function determines that
  <span>nodeOne</span> is an ancestor of <span>nodeTwo</span>, then it needs to
  see if <span>nodeThree</span> is a descendant of <span>nodeTwo</span>. If your
  function determines that <span>nodeThree</span> is an ancestor, then it needs
  to see if <span>nodeOne</span> is a descendant.
</p>
<p>
  A <b>descendant</b> of a node <span>N</span> is defined as a node contained in
  the tree rooted at <span>N</span>. A node <span>N</span> is an ancestor of
  another node <span>M</span> if <span>M</span> is a descendant of
  <span>N</span>.
</p>
<p>
  It isn't guaranteed that <span>nodeOne</span> or <span>nodeThree</span> will
  be ancestors or descendants of <span>nodeTwo</span>, but it is guaranteed that
  all three nodes will be unique and will never be <span>None</span> /
  <span>null</span>. In other words, you'll be given valid input nodes.
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
<pre style="position: relative;"><span class="CodeEditor-promptParameter">tree</span> =    5
       /     \
      2       7
    /   \   /   \
   1     4 6     8
  /     /
 0     3  
<span class="CodeEditor-promptComment">// This tree won't actually be passed as an input; it's here to help you visualize the problem.</span>
<span class="CodeEditor-promptParameter">nodeOne</span> = 5 <span class="CodeEditor-promptComment">// The actual node with value 5.</span>
<span class="CodeEditor-promptParameter">nodeTwo</span> = 2 <span class="CodeEditor-promptComment">// The actual node with value 2.</span>
<span class="CodeEditor-promptParameter">nodeThree</span> = 3 <span class="CodeEditor-promptComment">// The actual node with value 3.</span>
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
<h3>Sample Output</h3>
<pre style="position: relative;">true <span class="CodeEditor-promptComment">// nodeOne is an ancestor of nodeTwo, and nodeThree is a descendant of nodeTwo.</span>
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
</div>
"""


class BST:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def validateThreeNodes(nodeOne, nodeTwo, nodeThree):
    if isDescendant(nodeTwo, nodeOne):
        return isDescendant(nodeThree, nodeTwo)

    if isDescendant(nodeTwo, nodeThree):
        return isDescendant(nodeOne, nodeTwo)

    return False

def isDescendant(node, target):
    while node is not None and node is not target:
        node = node.left if target.value < node.value else node.right

    return node is target