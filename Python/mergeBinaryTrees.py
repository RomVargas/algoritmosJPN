"""
<div class="html">
  <p>
    Write a function that takes in two Binary Trees, merges them, and returns
    the resulting tree. If two nodes overlap during the merge, the value of the
    merged node should be the sum of the overlapping nodes' values.
  </p>
  <p>
    Note that your solution can either mutate the input trees or return a new
    tree.
  </p>
  <p>
    Each <span>BinaryTree</span> node has an integer <span>value</span>, a
    <span>left</span> child node, and a <span>right</span> child node. Children
    nodes can either be <span>BinaryTree</span> nodes themselves or
    <span>None</span> / <span>null</span>.
  </p>
  <h3>Sample Input</h3>
  <pre><span class="CodeEditor-promptParameter">tree1</span> =   1
        /   \
       3     2
     /   \
    7     4

<span class="CodeEditor-promptParameter">tree2</span> =   1
        /   \
       5     9
     /      / \
    2      7   6
</pre>
  <h3>Sample Output</h3>
  <pre><span class="CodeEditor-promptParameter">output</span> =  2
        /   \
      8      11
    /  \    /  \
  9     4  7    6
</pre>
</div>

"""

# This is an input class. Do not edit.
class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def mergeBinaryTrees(tree1, tree2):
  """
  The function `mergeBinaryTrees` takes two binary trees as input and merges them by adding the values
  of corresponding nodes, returning the merged tree.
  
  :param tree1: The first binary tree that we want to merge
  :param tree2: The parameter "tree2" represents the second binary tree that we want to merge with the
  first binary tree
  :return: the merged binary tree, which is represented by the variable `tree1`.
  """
  if tree1 is None:
       return tree2
  if tree2 is None:
        return tree1

  tree1.value += tree2.value
  tree1.left = mergeBinaryTrees(tree1.left, tree2.left)
  tree1.right = mergeBinaryTrees(tree1.right, tree2. right)
  return tree1
