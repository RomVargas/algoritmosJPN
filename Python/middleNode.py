"""<div class="html">
  <p>
    You're given a Linked List with at least one node. Write a function
    that returns the middle node of the Linked List. If there are two middle
    nodes (i.e. an even length list), your function should return the second
    of these nodes.
  </p>

  <p>
    Each <span>LinkedList</span> node has an integer <span>value</span> as well as
    a <span>next</span> node pointing to the next node in the list or to
    <span>None</span> / <span>null</span> if it's the tail of the list.
  </p>

  <h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">linkedList</span> = 2 -&gt; 7 -&gt; 3 -&gt; 5</pre>
  <h3>Sample Output</h3>
<pre>3 -&gt; 5 <span class="CodeEditor-promptComment">// The middle could be 7 or 3,
// we return the second middle node</span></pre>
</div>"""

class LinkedList:
    def __init__(self, value):
        self.value = value
        self.next = None


def middleNode(linkedList):
    slowNode = linkedList
    fastNode = linkedList
    while fastNode and fastNode.next:
        slowNode = slowNode.next
        fastNode = fastNode.next.next
    return slowNode


class TestProgram(unittest.TestCase):
    def test_case_1(self):
        linkedList = program.LinkedList(0)
        linkedList.next = program.LinkedList(1)
        expected = program.LinkedList(2)
        linkedList.next.next = expected
        expected.next = program.LinkedList(3)
        actual = program.middleNode(linkedList)
        self.assertEqual(actual, expected)
