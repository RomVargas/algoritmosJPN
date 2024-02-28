"""
<div class="html">
<p>
  Write a function that takes in an array of positive integers and returns the
  maximum sum of non-adjacent elements in the array.
</p>
<p>If the input array is empty, the function should return <span>0</span>.</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">array</span> = [75, 105, 120, 75, 90, 135]
</pre>
<h3>Sample Output</h3>
<pre>330 <span class="CodeEditor-promptComment">// 75 + 120 + 135</span>
</pre>
</div>
"""
def maxSubsetSumNoAdjacent(array):
    if not len(array):
        return 0
    elif len(array) == 1:
        return array[0]
    second = array[0]
    first = max(array[0], array[1])
    for i in range(2, len(array)):
        current = max(first, second + array[i])
        second = first
        first = current
    return first