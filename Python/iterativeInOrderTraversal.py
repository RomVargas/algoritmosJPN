"""
<div class="html">
<p>
  Write a function that takes in a Binary Tree (where nodes have an additional
  pointer to their parent node) and traverses it iteratively using the in-order
  tree-traversal technique; the traversal should specifically <i>not</i> use
  recursion. As the tree is being traversed, a callback function passed in as an
  argument to the main function should be called on each node (i.e.,
  <span>callback(currentNode)</span>).
</p>
<p>
  Each <span>BinaryTree</span> node has an integer <span>value</span>, a
  <span>parent</span> node, a <span>left</span> child node, and a
  <span>right</span> child node. Children nodes can either be
  <span>BinaryTree</span> nodes themselves or <span>None</span> /
  <span>null</span>.
</p>
<h3>Sample Input</h3>
<pre style="position: relative;"><span class="CodeEditor-promptParameter">tree</span> =    1
       /     \
      2       3
    /       /   \
   4       6     7
     \
      9
<span class="CodeEditor-promptParameter">callback</span> = someCallback
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
<h3>Sample Output</h3>
<pre style="position: relative;"><span class="CodeEditor-promptComment">// The input callback will have been called in the following order:</span>
callback(4)
callback(9)
callback(2)
callback(1)
callback(6)
callback(3)
callback(7)
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
</div>
"""

def iterativeInOrderTraversal(tree, callback):
    previousNode = None
    currentNode = tree
    while currentNode is not None:
        if previousNode is None or previousNode == currentNode.parent:
            if currentNode.left is not None:
                nextNode = currentNode.left
            else:
                callback(currentNode)
                nextNode = (
                    currentNode.right if currentNode.right is not None else currentNode.parent
                )
        elif previousNode == currentNode.left:
            callback(currentNode)
            nextNode = currentNode.right if currentNode.right is not None else currentNode.parent
        else:
            nextNode = currentNode.parent
        previousNode = currentNode
        currentNode = nextNode