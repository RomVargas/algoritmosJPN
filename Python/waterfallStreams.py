"""<div class="html">
<p>
  You're given a two-dimensional array that represents the structure of an
  indoor waterfall and a positive integer that represents the column that the
  waterfall's water source will start at. More specifically, the water source
  will start directly above the structure and will flow downwards.
</p>
<p>
  Each row in the array contains <span>0</span>s and <span>1</span>s, where a
  <span>0</span> represents a free space and a <span>1</span> represents a block
  that water can't pass through. You can imagine that the last row of the array
  contains buckets that the water will eventually flow into; thus, the last row
  of the array will always contain only <span>0</span>s. You can also imagine
  that there are walls on both sides of the structure, meaning that water will
  never leave the structure; it will either be trapped against a wall or flow
  into one of the buckets in the last row.
</p>
<p>
  As water flows downwards, if it hits a block, it splits evenly to the left and
  right-hand side of that block. In other words, 50% of the water flows left and
  50% of it flows right. If a water stream is unable to flow to the left or to
  the right (because of a block or a wall), the water stream in question becomes
  trapped and can no longer continue to flow in that direction; it effectively
  gets stuck in the structure and can no longer flow downwards, meaning that 50%
  of the previous water stream is forever lost.
</p>
<p>
  Lastly, the input array will always contain at least two rows and one column,
  and the space directly below the water source (in the first row of the array)
  will always be empty, allowing the water to start flowing downwards.
</p>
<p>
  Write a function that returns the percentage of water inside each of the
  bottom buckets after the water has flowed through the entire structure.
</p>
<p>
  You can refer to the first 4.5 minutes of this question's video explanation
  for a visual example.
</p>
<h3>Sample Input</h3>
<pre style="position: relative;"><span class="CodeEditor-promptParameter">array</span> = [
  [0, 0, 0, 0, 0, 0, 0],
  [1, 0, 0, 0, 0, 0, 0],
  [0, 0, 1, 1, 1, 0, 0],
  [0, 0, 0, 0, 0, 0, 0],
  [1, 1, 1, 0, 0, 1, 0],
  [0, 0, 0, 0, 0, 0, 1],
  [0, 0, 0, 0, 0, 0, 0],
]
<span class="CodeEditor-promptParameter">source</span> = 3
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
<h3>Sample Output</h3>
<pre style="position: relative;">[0, 0, 0, 25, 25, 0, 0]

<span class="CodeEditor-promptComment">// The water will flow as follows:</span>
<span class="CodeEditor-promptComment">// [</span>
<span class="CodeEditor-promptComment">//   [0, 0, 0, ., 0, 0, 0],</span>
<span class="CodeEditor-promptComment">//   [1, ., ., ., ., ., 0],</span>
<span class="CodeEditor-promptComment">//   [0, ., 1, 1, 1, ., 0],</span>
<span class="CodeEditor-promptComment">//   [., ., ., ., ., ., .],</span>
<span class="CodeEditor-promptComment">//   [1, 1, 1, ., ., 1, 0],</span>
<span class="CodeEditor-promptComment">//   [0, 0, 0, ., ., 0, 1],</span>
<span class="CodeEditor-promptComment">//   [0, 0, 0, ., ., 0, 0],</span>
<span class="CodeEditor-promptComment">// ]</span>
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
</div>"""

def waterfallStreams(array, source):
    rowAbove = array[0][:]

    rowAbove[source] = -1

    for row in range(1, len(array)):
        currentRow = array[row][:]

        for idx in range(len(rowAbove)):
            valueAbove = rowAbove[idx]

            hasWaterAbove = valueAbove < 0
            hasBlock = currentRow[idx] == 1

            if not hasWaterAbove:
                continue

            if not hasBlock:
                currentRow[idx] += valueAbove
                continue

            splitWater = valueAbove / 2

            rightIdx = idx
            while rightIdx + 1 < len(rowAbove):
                rightIdx += 1
                if rowAbove[rightIdx] == 1:
                    break
                if currentRow[rightIdx] != 1:
                    currentRow[rightIdx] += splitWater
                    break

            leftIdx = idx
            while leftIdx - 1 >= 0:
                leftIdx -= 1
                if rowAbove[leftIdx] == 1:
                    break
                if currentRow[leftIdx] != 1:
                    currentRow[leftIdx] += splitWater
                    break
                    
        rowAbove = currentRow

    finalPercentages = list(map(lambda num: num * -100, rowAbove))

    return finalPercentages