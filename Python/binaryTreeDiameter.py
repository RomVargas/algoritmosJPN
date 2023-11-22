"""<div class="html">
<p>
  Write a function that takes in a Binary Tree and returns its diameter. The
  diameter of a binary tree is defined as the length of its longest path, even
  if that path doesn't pass through the root of the tree.
</p>
<p>
  A path is a collection of connected nodes in a tree, where no node is
  connected to more than two other nodes. The length of a path is the number of
  edges between the path's first node and its last node.
</p>
<p>
  Each <span>BinaryTree</span> node has an integer <span>value</span>, a
  <span>left</span> child node, and a <span>right</span> child node. Children
  nodes can either be <span>BinaryTree</span> nodes themselves or
  <span>None</span> / <span>null</span>.
</p>
<h3>Sample Input</h3>
<pre style="position: relative;"><span class="CodeEditor-promptParameter">tree</span> =        1
            /   \
           3     2
         /   \ 
        7     4
       /       \
      8         5
     /           \
    9             6
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
<h3>Sample Output</h3>
<pre style="position: relative;">6 <span class="CodeEditor-promptComment">// 9 -&gt; 8 -&gt; 7 -&gt; 3 -&gt; 4 -&gt; 5 -&gt; 6</span>
<span class="CodeEditor-promptComment">// There are 6 edges between the</span>
<span class="CodeEditor-promptComment">// first node and the last node</span>
<span class="CodeEditor-promptComment">// of this tree's longest path.</span>
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
</div>"""

class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def binaryTreeDiameter(tree):
    return getTreeInfo(tree).diameter
    
def getTreeInfo(tree):
    if tree is None:
        return TreeInfo(0,0)

    leftTreeInfo = getTreeInfo(tree.left)
    rightTreeInfo = getTreeInfo(tree.right)

    longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height
    maxDiameterSoFar = max(leftTreeInfo.diameter, rightTreeInfo.diameter)
    currentDiameter = max(longestPathThroughRoot, maxDiameterSoFar)
    currentHeight = 1 + max(leftTreeInfo.height,rightTreeInfo.height)

    return TreeInfo(currentDiameter, currentHeight)

class TreeInfo:
    def __init__(self, diameter, height):
        self.diameter = diameter
        self.height = height

longestPathThroughtRoot
longestPathThroughRoot
import program
import unittest


class TestProgram(unittest.TestCase):
    def test_case_1(self):
        root = program.BinaryTree(1)
        root.left = program.BinaryTree(3)
        root.left.left = program.BinaryTree(7)
        root.left.left.left = program.BinaryTree(8)
        root.left.left.left.left = program.BinaryTree(9)
        root.left.right = program.BinaryTree(4)
        root.left.right.right = program.BinaryTree(5)
        root.left.right.right.right = program.BinaryTree(6)
        root.right = program.BinaryTree(2)
        expected = 6
        actual = program.binaryTreeDiameter(root)
        self.assertEqual(actual, expected)
