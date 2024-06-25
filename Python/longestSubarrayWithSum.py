"""
<div class="html">
<p>
  Write a function that takes in a non-empty array of non-negative integers and a non-negative integer
  representing a target sum. The function should find the longest subarray where the values collectively
  sum up to equal the target sum. Return an array containing the starting index and ending index of this subarray,
  both inclusive.
</p>
<p>
  If there is no subarray that sums up to the target sum, the function should return an
  empty array. You can assume that the given inputs will only ever have one answer.
</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">array</span> = [1, 2, 3, 4, 3, 3, 1, 2, 1, 2]
<span class="CodeEditor-promptParameter">targetSum</span> = 10
</pre>
<h3>Sample Output</h3>
<pre>[4, 8] <span class="CodeEditor-promptComment"> // The longest subarray that sums to 10 starts at index 4 and ends at index 8
</span>
</pre>
</div>
"""


def longestSubarrayWithSum(array, targetSum):
    indices = []

    for startingIndex in range(len(array)):
        currentSubarraySum = 0
    
        for endingIndex in range(startingIndex, len(array)):
            currentSubarraySum += array[endingIndex]
    
            if currentSubarraySum == targetSum:
                if len(indices) == 0 or indices[1] - indices[0] < endingIndex - startingIndex:
                    indices = [startingIndex, endingIndex]

    return indices