"""
<div class="html">
<p>
  Write a function that takes in an array of integers and returns an array of
  the same length, where each element in the output array corresponds to the
  number of integers in the input array that are to the right of the relevant
  index and that are strictly smaller than the integer at that index.
</p>
<p>
  In other words, the value at <span>output[i]</span> represents the number of
  integers that are to the right of <span>i</span> and that are strictly smaller
  than <span>input[i]</span>.
</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">array</span> = [8, 5, 11, -1, 3, 4, 2]
</pre>
<h3>Sample Output</h3>
<pre>[5, 4, 4, 0, 1, 1, 0]
<span class="CodeEditor-promptComment">// There are 5 integers smaller than 8 to the right of it.</span>
<span class="CodeEditor-promptComment">// There are 4 integers smaller than 5 to the right of it.</span>
<span class="CodeEditor-promptComment">// There are 4 integers smaller than 11 to the right of it.</span>
<span class="CodeEditor-promptComment">// Etc..</span>
</pre>
</div>
"""

def rightSmallerThan(array):
    rightSmallerCounts = []
    for i in range(len(array)):
        rightSmallerCount = 0
        for j in range(i + 1, len(array)):
            if array[j] < array[i]:
                rightSmallerCount += 1
        rightSmallerCounts.append(rightSmallerCount)
    return rightSmallerCounts