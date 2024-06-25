"""
<div class="html">
<p>
  You're given three inputs, all of which are instances of an
  <span>AncestralTree</span> class that have an <span>ancestor</span> property
  pointing to their youngest ancestor. The first input is the top ancestor in an
  ancestral tree (i.e., the only instance that has no ancestor--its
  <span>ancestor</span> property points to <span>None</span> /
  <span>null</span>), and the other two inputs are descendants in the ancestral
  tree.
</p>
<p>
  Write a function that returns the youngest common ancestor to the two
  descendants.
</p>
<p>
  Note that a descendant is considered its own ancestor. So in the simple
  ancestral tree below, the youngest common ancestor to nodes A and B is node A.
</p>
<pre><span class="CodeEditor-promptComment">// The youngest common ancestor to nodes A and B is node A.</span>
  A
 /
B
</pre>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptComment">// The nodes are from the ancestral tree below.</span>
<span class="CodeEditor-promptParameter">topAncestor</span> = node A
<span class="CodeEditor-promptParameter">descendantOne</span> = node E
<span class="CodeEditor-promptParameter">descendantTwo</span> = node I
          A
       /     \
      B       C
    /   \   /   \
   D     E F     G
 /   \
H     I
</pre>
<h3>Sample Output</h3>
<pre>node B
</pre>
</div>
"""

class AncestralTree:
    def __init__(self, name):
        self.name = name
        self.ancestor = None


def getYoungestCommonAncestor(topAncestor, descendantOne, descendantTwo):
    depthOne = getDescendantDepth(descendantOne, topAncestor)
    depthTwo = getDescendantDepth(descendantTwo, topAncestor)
    if depthOne > depthTwo:
        return backtrackAncestralTree(descendantOne, descendantTwo, depthOne - depthTwo)
    else:
        return backtrackAncestralTree(descendantTwo, descendantOne, depthTwo - depthOne)

def getDescendantDepth(descendant, topAncestor):
    depth = 0
    while descendant != topAncestor:
        depth += 1
        descendant = descendant.ancestor
    return depth


def backtrackAncestralTree(lowerDescendant, higherDescendant, diff):
    while diff > 0:
        lowerDescendant = lowerDescendant.ancestor
        diff -= 1
    while lowerDescendant != higherDescendant:
        lowerDescendant = lowerDescendant.ancestor
        higherDescendant = higherDescendant.ancestor
    return lowerDescendant