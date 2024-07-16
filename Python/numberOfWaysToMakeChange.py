"""
<div class="html">
<p>
  Given an array of distinct positive integers representing coin denominations and a
  single non-negative integer <span>n</span> representing a target amount of
  money, write a function that returns the number of ways to make change for
  that target amount using the given coin denominations.
</p>
<p>Note that an unlimited amount of coins is at your disposal.</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">n</span> = 6
<span class="CodeEditor-promptParameter">denoms</span> = [1, 5]
</pre>
<h3>Sample Output</h3>
<pre>2 <span class="CodeEditor-promptComment">// 1x1 + 1x5 and 6x1</span>
</pre>
</div>
"""
def numberOfWaysToMakeChange(n, denoms):
    ways = [0 for amount in range(n + 1)]
    ways[0] = 1
    for denom in denoms:
        for amount in range(1, n + 1):
            if denom <= amount:
                ways[amount] += ways[amount - denom]
    return ways[n]