"""
<div class="html">
<p>
  You're given two positive integers representing the width and height of a
  grid-shaped, rectangular graph. Write a function that returns the number of
  ways to reach the bottom right corner of the graph when starting at the top
  left corner. Each move you take must either go down or right. In other words,
  you can never move up or left in the graph.
</p>
<p>
  For example, given the graph illustrated below, with
  <span>width = 2</span> and <span>height = 3</span>, there are three ways to
  reach the bottom right corner when starting at the top left corner:
</p>
<pre style="position: relative;"> _ _
|_|_|
|_|_|
|_|_|
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
<ol>
  <li>Down, Down, Right</li>
  <li>Right, Down, Down</li>
  <li>Down, Right, Down</li>
</ol>
<p>
  Note: you may assume that <span>width * height &gt;= 2</span>. In other words,
  the graph will never be a 1x1 grid.
</p>
<h3>Sample Input</h3>
<pre style="position: relative;"><span class="CodeEditor-promptParameter">width</span> = 4
<span class="CodeEditor-promptParameter">height</span> = 3
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
<h3>Sample Output</h3>
<pre style="position: relative;">10
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
</div>
"""

def numberOfWaysToTraverseGraph(width, height):
    if width == 1 or height == 1:
        return 1

    return numberOfWaysToTraverseGraph(width - 1, height) + numberOfWaysToTraverseGraph(width, height - 1)


def numberOfWaysToTraverseGraph2(width, height):
    xDistanceToCorner = width - 1
    yDistanceToCorner = height - 1

    numerator = factorial(xDistanceToCorner + yDistanceToCorner)
    denominator = factorial(xDistanceToCorner) * factorial(yDistanceToCorner)
    return numerator // denominator

def factorial(num):
    result = 1

    for n in range(2, num + 1):
        result *= n

    return result
    