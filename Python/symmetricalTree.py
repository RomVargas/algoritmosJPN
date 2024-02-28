"""
  <div class="html">
<p>
  Write a function that takes in a Binary Tree and returns if that tree is
  symmetrical. A tree is symmetrical if the left and right subtrees are
  mirror images of each other.
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
      2       2
    /   \   /   \
   3     4 4     3
 /   \          /  \
5     6        6    5
</pre>
<h3>Sample Output</h3>
<pre>True</pre>
</div>  
"""

class BinaryTree:
    """
    The `symmetricalTree` function checks if a binary tree is symmetrical by comparing the values of
    corresponding nodes in the left and right subtrees.
    
    :param tree: The `tree` parameter in the `symmetricalTree` function is an instance of the
    `BinaryTree` class. It represents the root of a binary tree. The binary tree can have nodes with
    values and left and right child nodes. The `left` and `right` parameters in the `
    :return: The function `symmetricalTree` returns a boolean value. It returns `True` if the binary
    tree is symmetrical (i.e., a mirror image of itself), and `False` otherwise.
    """
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def symmetricalTree(tree):
    stackLeft = [tree.left]
    stackRight = [tree.right]

    while len(stackLeft) > 0:
        left = stackLeft.pop()
        right = stackRight.pop()

        if left is None and right is None:
            continue
    
        if left is None or right is None or left.value != right.value:
            return False
    
        stackLeft.append(left.left)
        stackLeft.append(left.right)
        stackRight.append(right.right)
        stackRight.append(right.left)

    return True