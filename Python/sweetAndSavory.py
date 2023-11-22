"""
<div class="html">
  <p>
    You're hosting an event at a food festival and want to showcase the best
    possible pairing of two dishes from the festival that complement each
    other's flavor profile.
  </p>

  <p>
    Each dish has a flavor profile represented by an integer. A negative integer
    means a dish is sweet, while a positive integer means a dish is savory. The
    absolute value of that integer represents the intensity of that flavor. For
    example, a flavor profile of -3 is slightly sweet, one of -10 is extremely
    sweet, one of 2 is mildly savory, and one of 8 is significantly savory.
  </p>

  <p>
    You're given an array of these dishes and a target combined flavor profile.
    Write a function that returns the best possible pairing of two dishes (the
    pairing with a total flavor profile that's closest to the target one). Note
    that this pairing must include one sweet and one savory dish. You're also
    concerned about the dish being too savory, so your pairing should never be
    more savory than the target flavor profile.
  </p>

  <p>
    All dishes will have a positive or negative flavor profile; there are no
    dishes with a 0 value. For simplicity, you can assume that there will be at
    most one best solution. If there isn't a valid solution, your function
    should return <span>[0, 0]</span>. The returned array should be sorted,
    meaning the sweet dish should always come first.
  </p>

  <h3>Sample Input #1</h3>
  <pre><span class="CodeEditor-promptParameter">dishes</span> = [-3, -5, 1, 7]   
<span class="CodeEditor-promptParameter">target</span> = 8
</pre>
  <h3>Sample Output #1</h3>
  <pre>[-3, 7] <span class="CodeEditor-promptComment">// The combined profile of 4 is closest without going over</span>
</pre>

  <h3>Sample Input #2</h3>
  <pre><span class="CodeEditor-promptParameter">dishes</span> = [3, 5, 7, 2, 6, 8, 1]  
<span class="CodeEditor-promptParameter">target</span> = 10
</pre>
  <h3>Sample Output #2</h3>
  <pre>[0, 0] <span class="CodeEditor-promptComment">// There are no sweet dishes
</span>
</pre>

  <h3>Sample Input #3</h3>
  <pre><span class="CodeEditor-promptParameter">dishes</span> = [2, 5, -4, -7, 12, 100, -25]  
<span class="CodeEditor-promptParameter">target</span> = -20
</pre>
  <h3>Sample Output #3</h3>
  <pre>[-25, 5] <span class="CodeEditor-promptComment">// This pairing gets the exact combined profile of -20</span>
</pre>
</div>
"""
def sweetAndSavory(dishes, target):
    sweetDishes = sorted([dish for dish in dishes if dish < 0] , key=abs)
    savoryDishes = sorted([dish for dish in dishes if dish > 0])

    bestPair = [0,0]
    bestDifference = float("inf")
    sweetIndex, savoryIndex = 0,0

    while sweetIndex < len(sweetDishes) and savoryIndex < len(savoryDishes):
        currentSum = sweetDishes[sweetIndex] + savoryDishes[savoryIndex]

        if currentSum <= target:
            currentDifference = target - currentSum
            if currentDifference < bestDifference:
                bestDifference = currentDifference
                bestPair = [sweetDishes[sweetIndex], savoryDishes[savoryIndex]]
            savoryIndex += 1
        else:
            sweetIndex += 1

    return bestPair