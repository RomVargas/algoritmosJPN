"""
<div class="html">
<p>
  Write a function that takes in an array of integers and returns an array of
  length 2 representing the largest range of integers contained in that array.
</p>
<p>
  The first number in the output array should be the first number in the range,
  while the second number should be the last number in the range.
</p>
<p>
  A range of numbers is defined as a set of numbers that come right after each
  other in the set of real integers. For instance, the output array
  <span>[2, 6]</span> represents the range <span>{2, 3, 4, 5, 6}</span>, which
  is a range of length 5. Note that numbers don't need to be sorted or adjacent
  in the input array in order to form a range.
</p>
<p>You can assume that there will only be one largest range.</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">array</span> = [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]
</pre>
<h3>Sample Output</h3>
<pre>[0, 7]
</pre>
</div>
"""

def largestRange(array):
    bestRange = []
    longestLength = 0
    nums = {}
    for num in array:
        nums[num] = True
    for num in array:
        if not nums[num]:
            continue
        nums[num] = False
        currentLength = 1
        left = num - 1
        right = num + 1
        while left in nums:
            nums[left] = False
            currentLength += 1
            left -= 1
        while right in nums:
            nums[right] = False
            currentLength += 1
            right += 1
        if currentLength > longestLength:
            longestLength = currentLength
            bestRange = [left + 1, right - 1]
    return bestRange