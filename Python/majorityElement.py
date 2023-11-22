"""
<div class="html">
  <p>
    Write a function that takes in a non-empty, unordered <span>array</span> of
    positive integers and returns the array's majority element without sorting
    the array and without using more than constant space.
  </p>
  <p>
    An array's majority element is an element of the array that appears in over
    half of its indices. Note that the most common element of an array (the
    element that appears the most times in the array) isn't necessarily the
    array's majority element; for example, the arrays
    <span>[3, 2, 2, 1]</span> and <span>[3, 4, 2, 2, 1]</span> both have
    <span>2</span> as their most common element, yet neither of these arrays
    have a majority element, because neither <span>2</span> nor any other
    element appears in over half of the respective arrays' indices.
  </p>
  <p>
    You can assume that the input array will always have a majority element.
  </p>
  <h3>Sample Input</h3>
  <pre><span class="CodeEditor-promptParameter">array</span> = [1, 2, 3, 2, 2, 1, 2]</pre>
  <h3>Sample Output</h3>
  <pre>2<span class="CodeEditor-promptComment"> // 2 occurs in 4/7 array indices, making it the majority element</span>
</pre>
</div>
"""

import ipdb

def majorityElement(array):
    count = 0
    answer = None
    #ipdb.set_trace()
    for value in array:
        if count == 0:
            answer = value

        if value == answer:
            count += 1
        else:
            count -= 1
    
    return answer

array = [1, 2, 3, 1,1, 1, 3,1]
print(majorityElement(array))