"""
<div class="html">
<p>
  Given an array of positive integers representing coin denominations and a
  single non-negative integer <span>n</span> representing a target amount of
  money, write a function that returns the smallest number of coins needed to
  make change for (to sum up to) that target amount using the given coin
  denominations.
</p>
<p>
  Note that you have access to an unlimited amount of coins. In other words, if
  the denominations are <span>[1, 5, 10]</span>, you have access to an unlimited
  amount of <span>1</span>s, <span>5</span>s, and <span>10</span>s.
</p>
<p>
  If it's impossible to make change for the target amount, return
  <span>-1</span>.
</p>
<h3>Sample Input</h3>
<pre style="position: relative;"><span class="CodeEditor-promptParameter">n</span> = 7
<span class="CodeEditor-promptParameter">denoms</span> = [1, 5, 10]
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
<h3>Sample Output</h3>
<pre style="position: relative;">3 <span class="CodeEditor-promptComment">// 2x1 + 1x5</span>
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
</div>
"""

def minNumberOfCoinsForChange(n, denoms):
    numOfCoins = [float("inf") for amount in range(n + 1)]
    numOfCoins[0] = 0
    for denom in denoms:
        for amount in range(len(numOfCoins)):
            if denom <= amount:
                numOfCoins[amount] = min(numOfCoins[amount], numOfCoins[amount - denom] + 1)
    return numOfCoins[n] if numOfCoins[n] != float("inf") else -1