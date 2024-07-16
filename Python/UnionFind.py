"""
<div class="html">
<p>
  The union-find data structure is similar to a traditional set data structure
  in that it contains a collection of unique values. However, these values are
  spread out amongst a variety of distinct disjoint sets, meaning that no set
  can have duplicate values, and no two sets can contain the same value.
</p>

<p>
  Write a <span>UnionFind</span> class that implements the union-find (also
  called a disjoint set) data structure. This class should support three methods:
</p>

<ul>
  <li>
    <span>createSet(value)</span>: Adds a given value in a new set containing
    only that value.
  </li>
  <li>
    <span>union(valueOne, valueTwo)</span>: Takes in two values and determines
    which sets they are in. If they are in different sets, the sets are combined
    into a single set. If either value is not in a set or they are in the same
    set, the function should have no effect.
  </li>
  <li>
    <span>find(value)</span>: Returns the "representative" value of the set for
    which a value belongs to. This can be any value in the set, but it should
    always be the same value, regardless of which value in the set
    <span>find</span> is passed. If the value is not in a set, the function
    should return <span>null</span> / <span>None</span>. Note that after a set
    is part of a union, its representative can potentially change.
  </li>
</ul>
<p>
  You can assume <span>createSet</span> will never be called with the same
  value twice.
</p>

<p>
  If you're unfamiliar with Union Find, we recommend watching the Conceptual
  Overview section of this question's video explanation before starting to code.
</p>

<h3>Sample Usage</h3>
<pre style="position: relative;"><span class="CodeEditor-promptParameter">createSet</span>(5): null
<span class="CodeEditor-promptParameter">createSet</span>(10): null
<span class="CodeEditor-promptParameter">find</span>(5): 5
<span class="CodeEditor-promptParameter">find</span>(10): 10
<span class="CodeEditor-promptParameter">union</span>(5, 10): null
<span class="CodeEditor-promptParameter">find</span>(5): 5
<span class="CodeEditor-promptParameter">find</span>(10): 5
<span class="CodeEditor-promptParameter">createSet</span>(20): null
<span class="CodeEditor-promptParameter">find</span>(20): 20
<span class="CodeEditor-promptParameter">union</span>(20, 10): null
<span class="CodeEditor-promptParameter">find</span>(5): 5
<span class="CodeEditor-promptParameter">find</span>(10): 5
<span class="CodeEditor-promptParameter">find</span>(20): 5
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
</div>
"""

class UnionFind:
    def __init__(self):
        self.parents = {}

    def createSet(self, value):
        self.parents[value] = value

    def find(self, value):
        if value not in self.parents:
            return None

        currentParent = value
        while currentParent != self.parents[currentParent]:
            currentParent = self.parents[currentParent]
        return currentParent

    def union(self, valueOne, valueTwo):
        if valueOne not in self.parents or valueTwo not in self.parents:
            return

        valueOneRoot = self.find(valueOne)
        valueTwoRoot = self.find(valueTwo)
        self.parents[valueTwoRoot] = valueOneRoot
